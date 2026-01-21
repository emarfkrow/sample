package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb7Sum;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 集約削除
 *
 * @author emarfkrow
 */
public class Tb7SumDeleteAction extends BaseAction {

    /** 集約削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object sumId = postJson.get("sumId");
        if (sumId == null) {
            sumId = postJson.get("Tb7Sum.sumId");
        }
        if (sumId == null) {
            throw new OptLockError("error.cant.delete", "集約");
        }

        Tb7Sum e = FormValidator.toBean(Tb7Sum.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "集約");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
