package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb2Eldest;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 長兄削除
 *
 * @author emarfkrow
 */
public class Tb2EldestDeleteAction extends BaseAction {

    /** 長兄削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object broId = postJson.get("broId");
        if (broId == null) {
            broId = postJson.get("Tb2Eldest.broId");
        }
        if (broId == null) {
            throw new OptLockError("error.cant.delete", "長兄");
        }

        Tb2Eldest e = FormValidator.toBean(Tb2Eldest.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "長兄");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
