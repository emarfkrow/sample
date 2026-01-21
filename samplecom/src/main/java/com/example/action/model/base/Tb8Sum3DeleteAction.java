package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Sum3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 集約３削除
 *
 * @author emarfkrow
 */
public class Tb8Sum3DeleteAction extends BaseAction {

    /** 集約３削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object sum3Id = postJson.get("sum3Id");
        if (sum3Id == null) {
            sum3Id = postJson.get("Tb8Sum3.sum3Id");
        }
        if (sum3Id == null) {
            throw new OptLockError("error.cant.delete", "集約３");
        }

        Tb8Sum3 e = FormValidator.toBean(Tb8Sum3.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "集約３");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
