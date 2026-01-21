package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Combo2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 複合２削除
 *
 * @author emarfkrow
 */
public class Tb1Combo2DeleteAction extends BaseAction {

    /** 複合２削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object refer1Id = postJson.get("refer1Id");
        if (refer1Id == null) {
            refer1Id = postJson.get("Tb1Combo2.refer1Id");
        }
        if (refer1Id == null) {
            throw new OptLockError("error.cant.delete", "複合２");
        }
        Object refer2Id = postJson.get("refer2Id");
        if (refer2Id == null) {
            refer2Id = postJson.get("Tb1Combo2.refer2Id");
        }
        if (refer2Id == null) {
            throw new OptLockError("error.cant.delete", "複合２");
        }
        Object refer3Id = postJson.get("refer3Id");
        if (refer3Id == null) {
            refer3Id = postJson.get("Tb1Combo2.refer3Id");
        }
        if (refer3Id == null) {
            throw new OptLockError("error.cant.delete", "複合２");
        }
        Object tekiyoBi = postJson.get("tekiyoBi");
        if (tekiyoBi == null) {
            tekiyoBi = postJson.get("Tb1Combo2.tekiyoBi");
        }
        if (tekiyoBi == null) {
            throw new OptLockError("error.cant.delete", "複合２");
        }

        Tb1Combo2 e = FormValidator.toBean(Tb1Combo2.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "複合２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
