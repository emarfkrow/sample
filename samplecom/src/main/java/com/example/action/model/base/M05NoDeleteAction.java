package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M05No;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * NOマスタ削除
 *
 * @author emarfkrow
 */
public class M05NoDeleteAction extends BaseAction {

    /** NOマスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object norefNo = form.get("norefNo");
        if (norefNo == null) {
            norefNo = form.get("M05No.norefNo");
        }
        if (norefNo == null) {
            throw new OptLockError("error.cant.delete", "NOマスタ");
        }

        M05No e = FormValidator.toBean(M05No.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "NOマスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
