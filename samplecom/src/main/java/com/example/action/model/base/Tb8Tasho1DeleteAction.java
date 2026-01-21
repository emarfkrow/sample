package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Tasho1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 他生１削除
 *
 * @author emarfkrow
 */
public class Tb8Tasho1DeleteAction extends BaseAction {

    /** 他生１削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object tasho1Id = postJson.get("tasho1Id");
        if (tasho1Id == null) {
            tasho1Id = postJson.get("Tb8Tasho1.tasho1Id");
        }
        if (tasho1Id == null) {
            throw new OptLockError("error.cant.delete", "他生１");
        }

        Tb8Tasho1 e = FormValidator.toBean(Tb8Tasho1.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "他生１");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
