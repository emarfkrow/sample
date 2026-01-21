package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Idbn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * ID連番マスタ削除
 *
 * @author emarfkrow
 */
public class Tb1IdbnDeleteAction extends BaseAction {

    /** ID連番マスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object idrefId = postJson.get("idrefId");
        if (idrefId == null) {
            idrefId = postJson.get("Tb1Idbn.idrefId");
        }
        if (idrefId == null) {
            throw new OptLockError("error.cant.delete", "ID連番マスタ");
        }
        Object idbnBn = postJson.get("idbnBn");
        if (idbnBn == null) {
            idbnBn = postJson.get("Tb1Idbn.idbnBn");
        }
        if (idbnBn == null) {
            throw new OptLockError("error.cant.delete", "ID連番マスタ");
        }

        Tb1Idbn e = FormValidator.toBean(Tb1Idbn.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "ID連番マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
