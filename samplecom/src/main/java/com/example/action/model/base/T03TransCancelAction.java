package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T03Trans;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 変遷取消
 *
 * @author emarfkrow
 */
public class T03TransCancelAction extends BaseAction {

    /** 変遷取消処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object transId = postJson.get("transId");
        if (transId == null) {
            transId = postJson.get("T03Trans.transId");
        }
        if (transId == null) {
            throw new OptLockError("error.cant.cancel", "変遷");
        }

        T03Trans e = FormValidator.toBean(T03Trans.class.getName(), postJson);

        e.setStatusKb(null);
        if (e.update(now, execId) != 1) {
            throw new OptLockError("error.cant.cancel", "変遷");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.cancel"));
        return map;
    }

}
