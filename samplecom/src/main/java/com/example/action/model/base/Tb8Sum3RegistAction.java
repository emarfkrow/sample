package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Sum3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 集約３登録
 *
 * @author emarfkrow
 */
public class Tb8Sum3RegistAction extends BaseAction {

    /** 集約３登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        Tb8Sum3 e = FormValidator.toBean(Tb8Sum3.class.getName(), postJson);

        // 主キーが不足していたらINSERT
        boolean isNew = false;
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(e.getSum3Id())) {
            isNew = true;
        }
        // 楽観ロック値がなくてもINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(e.getUpdateTs())) {
            isNew = true;
        }

        if (isNew) {

            if (e.insert(now, execId) != 1) {
                throw new OptLockError("error.cant.insert", "集約３");
            }

            //集約先に該当する場合は、集約元に主キーを反映
            String summaryKey1 = postJson.get("Tb8Unit4.unit4Id").toString();
            if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(summaryKey1)) {
                String[] summaryKeys = summaryKey1.trim().split(",");
                for (String pk : summaryKeys) {
                    com.example.entity.Tb8Unit4 tb8Unit4 = com.example.entity.Tb8Unit4.get(pk);
                    //集約済みならエラー
                    if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(tb8Unit4.getSum3Id())) {
                        throw new OptLockError("error.already.summary", "単位４");
                    }
                    tb8Unit4.setSum3Id(e.getSum3Id());
                    if (tb8Unit4.update(now, execId) != 1) {
                        throw new OptLockError("error.cant.insert", "単位４");
                    }
                }
            }

            map.put("INFO", Messages.get("info.insert"));

        } else {

            if (e.update(now, execId) == 1) {
                map.put("INFO", Messages.get("info.update"));
            } else if (e.insert(now, execId) == 1) {
                map.put("INFO", Messages.get("info.insert"));
            } else {
                throw new OptLockError("error.cant.update", "集約３");
            }
        }

        return map;
    }

}
