package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T10Grp2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 集団２削除
 *
 * @author emarfkrow
 */
public class T10Grp2DeleteAction extends BaseAction {

    /** 集団２削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object grp2Id = postJson.get("grp2Id");
        if (grp2Id == null) {
            grp2Id = postJson.get("T10Grp2.grp2Id");
        }
        if (grp2Id == null) {
            throw new OptLockError("error.cant.delete", "集団２");
        }

        T10Grp2 e = FormValidator.toBean(T10Grp2.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "集団２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
