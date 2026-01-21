package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.Tb4Mago;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 孫一覧登録
 *
 * @author emarfkrow
 */
public class Tb4MagoSRegistAction extends BaseAction {

    /** 孫一覧登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("Tb4MagoGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                Tb4Mago e = FormValidator.toBean(Tb4Mago.class.getName(), row);

                // 主キーが不足していたらINSERT
                boolean isNew = false;
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(e.getOyaId())) {
                    isNew = true;
                }
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(e.getKoBn())) {
                    isNew = true;
                }
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(e.getMagoBn())) {
                    isNew = true;
                }
                // 楽観ロック値がなくてもINSERT
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(e.getUpdateTs())) {
                    isNew = true;
                }

                if (isNew) {

                    if (e.insert(now, execId) != 1) {
                        throw new OptLockError("error.cant.insert", "孫");
                    }
                    ++count;

                } else {

                    if (e.update(now, execId) != 1) {
                        throw new OptLockError("error.cant.update", "孫");
                    }
                    ++count;
                }
            }
        }

        if (count == 0) {
            map.put("ERROR", Messages.get("error.nopost"));
            return map;
        }

        map.put("INFO", Messages.get("info.regist"));
        return map;
    }

}
