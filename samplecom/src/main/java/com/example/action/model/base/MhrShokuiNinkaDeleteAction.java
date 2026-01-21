package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MhrShokuiNinka;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 認可マスタ削除
 *
 * @author emarfkrow
 */
public class MhrShokuiNinkaDeleteAction extends BaseAction {

    /** 認可マスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object bushoId = postJson.get("bushoId");
        if (bushoId == null) {
            bushoId = postJson.get("MhrShokuiNinka.bushoId");
        }
        if (bushoId == null) {
            throw new OptLockError("error.cant.delete", "認可マスタ");
        }
        Object shokuiId = postJson.get("shokuiId");
        if (shokuiId == null) {
            shokuiId = postJson.get("MhrShokuiNinka.shokuiId");
        }
        if (shokuiId == null) {
            throw new OptLockError("error.cant.delete", "認可マスタ");
        }
        Object kinoNm = postJson.get("kinoNm");
        if (kinoNm == null) {
            kinoNm = postJson.get("MhrShokuiNinka.kinoNm");
        }
        if (kinoNm == null) {
            throw new OptLockError("error.cant.delete", "認可マスタ");
        }

        MhrShokuiNinka e = FormValidator.toBean(MhrShokuiNinka.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "認可マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
