package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Idref;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * ID参照マスタ削除
 *
 * @author emarfkrow
 */
public class Tb1IdrefDeleteAction extends BaseAction {

    /** ID参照マスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object idrefId = postJson.get("idrefId");
        if (idrefId == null) {
            idrefId = postJson.get("Tb1Idref.idrefId");
        }
        if (idrefId == null) {
            throw new OptLockError("error.cant.delete", "ID参照マスタ");
        }

        Tb1Idref e = FormValidator.toBean(Tb1Idref.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "ID参照マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
