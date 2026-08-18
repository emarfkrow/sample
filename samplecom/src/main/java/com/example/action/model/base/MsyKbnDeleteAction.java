package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MsyKbn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 区分マスタ削除
 *
 * @author emarfkrow
 */
public class MsyKbnDeleteAction extends BaseAction {

    /** 区分マスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object kbnNm = form.get("kbnNm");
        if (kbnNm == null) {
            kbnNm = form.get("MsyKbn.kbnNm");
        }
        if (kbnNm == null) {
            throw new OptLockError("error.cant.delete", "区分マスタ");
        }

        MsyKbn e = FormValidator.toBean(MsyKbn.class.getName(), form);

        java.util.List<com.example.entity.MsyKbnVal> msyKbnVals = e.referMsyKbnVals();
        if (msyKbnVals != null) {
            for (com.example.entity.MsyKbnVal msyKbnVal : msyKbnVals) {

                if (msyKbnVal.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "区分値マスタ");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "区分マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
