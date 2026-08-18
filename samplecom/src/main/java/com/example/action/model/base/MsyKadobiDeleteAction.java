package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MsyKadobi;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 稼働日マスタ削除
 *
 * @author emarfkrow
 */
public class MsyKadobiDeleteAction extends BaseAction {

    /** 稼働日マスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object kadoYmd = form.get("kadoYmd");
        if (kadoYmd == null) {
            kadoYmd = form.get("MsyKadobi.kadoYmd");
        }
        if (kadoYmd == null) {
            throw new OptLockError("error.cant.delete", "稼働日マスタ");
        }
        Object bushoId = form.get("bushoId");
        if (bushoId == null) {
            bushoId = form.get("MsyKadobi.bushoId");
        }
        if (bushoId == null) {
            throw new OptLockError("error.cant.delete", "稼働日マスタ");
        }

        MsyKadobi e = FormValidator.toBean(MsyKadobi.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "稼働日マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
