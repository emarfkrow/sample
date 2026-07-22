package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T10Grp1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 集団１削除
 *
 * @author emarfkrow
 */
public class T10Grp1DeleteAction extends BaseAction {

    /** 集団１削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object grp1Id = postJson.get("grp1Id");
        if (grp1Id == null) {
            grp1Id = postJson.get("T10Grp1.grp1Id");
        }
        if (grp1Id == null) {
            throw new OptLockError("error.cant.delete", "集団１");
        }

        T10Grp1 e = FormValidator.toBean(T10Grp1.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "集団１");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
