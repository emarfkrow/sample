package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T04Comp2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 複合２削除
 *
 * @author emarfkrow
 */
public class T04Comp2DeleteAction extends BaseAction {

    /** 複合２削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object ref1Id = postJson.get("ref1Id");
        if (ref1Id == null) {
            ref1Id = postJson.get("T04Comp2.ref1Id");
        }
        if (ref1Id == null) {
            throw new OptLockError("error.cant.delete", "複合２");
        }
        Object ref2Id = postJson.get("ref2Id");
        if (ref2Id == null) {
            ref2Id = postJson.get("T04Comp2.ref2Id");
        }
        if (ref2Id == null) {
            throw new OptLockError("error.cant.delete", "複合２");
        }
        Object ref3Id = postJson.get("ref3Id");
        if (ref3Id == null) {
            ref3Id = postJson.get("T04Comp2.ref3Id");
        }
        if (ref3Id == null) {
            throw new OptLockError("error.cant.delete", "複合２");
        }
        Object tekiyoBi = postJson.get("tekiyoBi");
        if (tekiyoBi == null) {
            tekiyoBi = postJson.get("T04Comp2.tekiyoBi");
        }
        if (tekiyoBi == null) {
            throw new OptLockError("error.cant.delete", "複合２");
        }

        T04Comp2 e = FormValidator.toBean(T04Comp2.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "複合２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
