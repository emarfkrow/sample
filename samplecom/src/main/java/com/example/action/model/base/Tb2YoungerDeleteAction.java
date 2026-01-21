package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb2Younger;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 弟削除
 *
 * @author emarfkrow
 */
public class Tb2YoungerDeleteAction extends BaseAction {

    /** 弟削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object broId = postJson.get("broId");
        if (broId == null) {
            broId = postJson.get("Tb2Younger.broId");
        }
        if (broId == null) {
            throw new OptLockError("error.cant.delete", "弟");
        }

        Tb2Younger e = FormValidator.toBean(Tb2Younger.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "弟");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
