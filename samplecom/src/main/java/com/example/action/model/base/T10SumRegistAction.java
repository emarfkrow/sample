package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T10Sum;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 集約登録
 *
 * @author emarfkrow
 */
public class T10SumRegistAction extends BaseAction {

    /** 集約登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        T10Sum e = FormValidator.toBean(T10Sum.class.getName(), form);

        if (e.isNew()) {

            if (e.insert(at, by) != 1) {
                throw new OptLockError("error.cant.insert", "集約");
            }

            //集約先に該当する場合は、集約元に主キーを反映
            String summaryKey1 = form.get("T10Grp1.grp1Id").toString();
            if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(summaryKey1)) {
                String[] summaryKeys = summaryKey1.trim().split(",");
                for (String pk : summaryKeys) {
                    com.example.entity.T10Grp1 t10Grp1 = com.example.entity.T10Grp1.get(pk);
                    //集約済みならエラー
                    if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(t10Grp1.getSumId())) {
                        throw new OptLockError("error.already.summary", "集団１");
                    }
                    t10Grp1.setSumId(e.getSumId());
                    if (t10Grp1.update(at, by) != 1) {
                        throw new OptLockError("error.cant.insert", "集団１");
                    }
                }
            }

            //集約先に該当する場合は、集約元に主キーを反映
            String summaryKey2 = form.get("T10Grp2.grp2Id").toString();
            if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(summaryKey2)) {
                String[] summaryKeys = summaryKey2.trim().split(",");
                for (String pk : summaryKeys) {
                    com.example.entity.T10Grp2 t10Grp2 = com.example.entity.T10Grp2.get(pk);
                    //集約済みならエラー
                    if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(t10Grp2.getSumId())) {
                        throw new OptLockError("error.already.summary", "集団２");
                    }
                    t10Grp2.setSumId(e.getSumId());
                    if (t10Grp2.update(at, by) != 1) {
                        throw new OptLockError("error.cant.insert", "集団２");
                    }
                }
            }

            map.put("INFO", Messages.get("info.insert"));

        } else {

            if (e.update(at, by) == 1) {
                map.put("INFO", Messages.get("info.update"));
            } else if (e.insert(at, by) == 1) {
                map.put("INFO", Messages.get("info.insert"));
            } else {
                throw new OptLockError("error.cant.update", "集約");
            }
        }

        return map;
    }

}
