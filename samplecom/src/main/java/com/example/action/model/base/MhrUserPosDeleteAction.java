package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MhrUserPos;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 所属マスタ削除
 *
 * @author emarfkrow
 */
public class MhrUserPosDeleteAction extends BaseAction {

    /** 所属マスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object bushoId = postJson.get("bushoId");
        if (bushoId == null) {
            bushoId = postJson.get("MhrUserPos.bushoId");
        }
        if (bushoId == null) {
            throw new OptLockError("error.cant.delete", "所属マスタ");
        }
        Object shokuiId = postJson.get("shokuiId");
        if (shokuiId == null) {
            shokuiId = postJson.get("MhrUserPos.shokuiId");
        }
        if (shokuiId == null) {
            throw new OptLockError("error.cant.delete", "所属マスタ");
        }
        Object userId = postJson.get("userId");
        if (userId == null) {
            userId = postJson.get("MhrUserPos.userId");
        }
        if (userId == null) {
            throw new OptLockError("error.cant.delete", "所属マスタ");
        }
        Object tekiyoBi = postJson.get("tekiyoBi");
        if (tekiyoBi == null) {
            tekiyoBi = postJson.get("MhrUserPos.tekiyoBi");
        }
        if (tekiyoBi == null) {
            throw new OptLockError("error.cant.delete", "所属マスタ");
        }

        MhrUserPos e = FormValidator.toBean(MhrUserPos.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "所属マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
