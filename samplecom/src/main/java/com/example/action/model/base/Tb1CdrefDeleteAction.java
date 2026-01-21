package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Cdref;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * CD参照マスタ削除
 *
 * @author emarfkrow
 */
public class Tb1CdrefDeleteAction extends BaseAction {

    /** CD参照マスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object cdrefCd = postJson.get("cdrefCd");
        if (cdrefCd == null) {
            cdrefCd = postJson.get("Tb1Cdref.cdrefCd");
        }
        if (cdrefCd == null) {
            throw new OptLockError("error.cant.delete", "CD参照マスタ");
        }

        Tb1Cdref e = FormValidator.toBean(Tb1Cdref.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "CD参照マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
