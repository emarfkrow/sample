package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb9Dest;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 変換先削除
 *
 * @author emarfkrow
 */
public class Tb9DestDeleteAction extends BaseAction {

    /** 変換先削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object destId = postJson.get("destId");
        if (destId == null) {
            destId = postJson.get("Tb9Dest.destId");
        }
        if (destId == null) {
            throw new OptLockError("error.cant.delete", "変換先");
        }

        Tb9Dest e = FormValidator.toBean(Tb9Dest.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "変換先");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
