package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb0Nokey;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 主キーなし削除
 *
 * @author emarfkrow
 */
public class Tb0NokeyDeleteAction extends BaseAction {

    /** 主キーなし削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object colD = postJson.get("colD");
        if (colD == null) {
            colD = postJson.get("Tb0Nokey.colD");
        }
        if (colD == null) {
            throw new OptLockError("error.cant.delete", "主キーなし");
        }
        Object colE = postJson.get("colE");
        if (colE == null) {
            colE = postJson.get("Tb0Nokey.colE");
        }
        if (colE == null) {
            throw new OptLockError("error.cant.delete", "主キーなし");
        }

        Tb0Nokey e = FormValidator.toBean(Tb0Nokey.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "主キーなし");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
