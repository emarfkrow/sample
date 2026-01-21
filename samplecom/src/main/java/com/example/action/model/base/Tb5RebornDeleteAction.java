package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb5Reborn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 転生削除
 *
 * @author emarfkrow
 */
public class Tb5RebornDeleteAction extends BaseAction {

    /** 転生削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object rebornId = postJson.get("rebornId");
        if (rebornId == null) {
            rebornId = postJson.get("Tb5Reborn.rebornId");
        }
        if (rebornId == null) {
            throw new OptLockError("error.cant.delete", "転生");
        }

        Tb5Reborn e = FormValidator.toBean(Tb5Reborn.class.getName(), postJson);

        java.util.List<com.example.entity.Tb5RebornDet> tb5RebornDets = e.referTb5RebornDets();
        if (tb5RebornDets != null) {
            for (com.example.entity.Tb5RebornDet tb5RebornDet : tb5RebornDets) {

                if (tb5RebornDet.delete() != 1) {
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
