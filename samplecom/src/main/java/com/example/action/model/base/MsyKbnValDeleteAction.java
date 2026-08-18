package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MsyKbnVal;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 区分値マスタ削除
 *
 * @author emarfkrow
 */
public class MsyKbnValDeleteAction extends BaseAction {

    /** 区分値マスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object kbnNm = form.get("kbnNm");
        if (kbnNm == null) {
            kbnNm = form.get("MsyKbnVal.kbnNm");
        }
        if (kbnNm == null) {
            throw new OptLockError("error.cant.delete", "区分値マスタ");
        }
        Object kbnVal = form.get("kbnVal");
        if (kbnVal == null) {
            kbnVal = form.get("MsyKbnVal.kbnVal");
        }
        if (kbnVal == null) {
            throw new OptLockError("error.cant.delete", "区分値マスタ");
        }

        MsyKbnVal e = FormValidator.toBean(MsyKbnVal.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "区分値マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
