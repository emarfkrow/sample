package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb7Unit1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 単位１削除
 *
 * @author emarfkrow
 */
public class Tb7Unit1DeleteAction extends BaseAction {

    /** 単位１削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object unit1Id = postJson.get("unit1Id");
        if (unit1Id == null) {
            unit1Id = postJson.get("Tb7Unit1.unit1Id");
        }
        if (unit1Id == null) {
            throw new OptLockError("error.cant.delete", "単位１");
        }

        Tb7Unit1 e = FormValidator.toBean(Tb7Unit1.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "単位１");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
