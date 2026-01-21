package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Sum2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 集約２削除
 *
 * @author emarfkrow
 */
public class Tb8Sum2DeleteAction extends BaseAction {

    /** 集約２削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object sum2Id = postJson.get("sum2Id");
        if (sum2Id == null) {
            sum2Id = postJson.get("Tb8Sum2.sum2Id");
        }
        if (sum2Id == null) {
            throw new OptLockError("error.cant.delete", "集約２");
        }

        Tb8Sum2 e = FormValidator.toBean(Tb8Sum2.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "集約２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
