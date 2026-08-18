package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T06Reborn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 転生削除
 *
 * @author emarfkrow
 */
public class T06RebornDeleteAction extends BaseAction {

    /** 転生削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object rebornId = form.get("rebornId");
        if (rebornId == null) {
            rebornId = form.get("T06Reborn.rebornId");
        }
        if (rebornId == null) {
            throw new OptLockError("error.cant.delete", "転生");
        }

        T06Reborn e = FormValidator.toBean(T06Reborn.class.getName(), form);

        java.util.List<com.example.entity.T06RebornDet> t06RebornDets = e.referT06RebornDets();
        if (t06RebornDets != null) {
            for (com.example.entity.T06RebornDet t06RebornDet : t06RebornDets) {

                if (t06RebornDet.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "転生明細");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "転生");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
