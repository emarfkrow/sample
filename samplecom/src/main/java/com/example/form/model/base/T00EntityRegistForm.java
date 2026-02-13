package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * エンティティ登録フォーム
 *
 * @author emarfkrow
 */
public class T00EntityRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(T00EntityRegistForm.class);

    /** エンティティID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String entityId;

    /** @return エンティティID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getEntityId() {
        return entityId;
    }

    /** @param p エンティティID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setEntityId(final String p) {
        this.entityId = p;
    }

    /** エンティティ名称 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 20)
    private String entityNm;

    /** @return エンティティ名称 */
    public String getEntityNm() {
        return entityNm;
    }

    /** @param p エンティティ名称 */
    public void setEntityNm(final String p) {
        this.entityNm = p;
    }

    /** エンティティ名 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String entityMei;

    /** @return エンティティ名 */
    public String getEntityMei() {
        return entityMei;
    }

    /** @param p エンティティ名 */
    public void setEntityMei(final String p) {
        this.entityMei = p;
    }

    /** チェックフラグ */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 1)
    private String checkF = "0";

    /** @return チェックフラグ */
    public String getCheckF() {
        return checkF;
    }

    /** @param p チェックフラグ */
    public void setCheckF(final String p) {
        this.checkF = p;
    }

    /** ラジオ区分 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 2)
    private String radioKb;

    /** @return ラジオ区分 */
    public String getRadioKb() {
        return radioKb;
    }

    /** @param p ラジオ区分 */
    public void setRadioKb(final String p) {
        this.radioKb = p;
    }

    /** プルダウン区分 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 2)
    private String pulldownKb;

    /** @return プルダウン区分 */
    public String getPulldownKb() {
        return pulldownKb;
    }

    /** @param p プルダウン区分 */
    public void setPulldownKb(final String p) {
        this.pulldownKb = p;
    }

    /** プルダウン種別 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 2)
    private String pulldownSb;

    /** @return プルダウン種別 */
    public String getPulldownSb() {
        return pulldownSb;
    }

    /** @param p プルダウン種別 */
    public void setPulldownSb(final String p) {
        this.pulldownSb = p;
    }

    /** メモ */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String memoTx;

    /** @return メモ */
    public String getMemoTx() {
        return memoTx;
    }

    /** @param p メモ */
    public void setMemoTx(final String p) {
        this.memoTx = p;
    }

    /** １行メモ */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String memo;

    /** @return １行メモ */
    public String getMemo() {
        return memo;
    }

    /** @param p １行メモ */
    public void setMemo(final String p) {
        this.memo = p;
    }

    /** 添付ファイル */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String tenpuFile;

    /** @return 添付ファイル */
    public String getTenpuFile() {
        return tenpuFile;
    }

    /** @param p 添付ファイル */
    public void setTenpuFile(final String p) {
        this.tenpuFile = p;
    }

    /** 年月日年 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,4})?")
    private String nengappiY;

    /** @return 年月日年 */
    public String getNengappiY() {
        return nengappiY;
    }

    /** @param p 年月日年 */
    public void setNengappiY(final String p) {
        this.nengappiY = p;
    }

    /** 年月日月 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,2})?")
    private String nengappiM;

    /** @return 年月日月 */
    public String getNengappiM() {
        return nengappiM;
    }

    /** @param p 年月日月 */
    public void setNengappiM(final String p) {
        this.nengappiM = p;
    }

    /** 年月日日 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,2})?")
    private String nengappiD;

    /** @return 年月日日 */
    public String getNengappiD() {
        return nengappiD;
    }

    /** @param p 年月日日 */
    public void setNengappiD(final String p) {
        this.nengappiD = p;
    }

    /** 年月 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,4}(\\/|\\-)?[0-9]{1,2})?")
    private String nengetsuYm;

    /** @return 年月 */
    public String getNengetsuYm() {
        return nengetsuYm;
    }

    /** @param p 年月 */
    public void setNengetsuYm(final String p) {
        this.nengetsuYm = p;
    }

    /** 年月日 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{8})?")
    private String nengappiYmd;

    /** @return 年月日 */
    public String getNengappiYmd() {
        return nengappiYmd;
    }

    /** @param p 年月日 */
    public void setNengappiYmd(final String p) {
        this.nengappiYmd = p;
    }

    /** タイムスタンプ */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{13}|[0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2}(T| )[0-9]{1,2}:[0-9]{1,2}(:[0-9]{1,2}(\\.[0-9]{3})?)?)?")
    private String timestampTs;

    /** @return タイムスタンプ */
    public String getTimestampTs() {
        return timestampTs;
    }

    /** @param p タイムスタンプ */
    public void setTimestampTs(final String p) {
        this.timestampTs = p;
    }

    /** 日時 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{13}|[0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2}(T| )[0-9]{1,2}:[0-9]{1,2}(:[0-9]{1,2}(\\.[0-9]{3})?)?)?")
    private String nichijiDt;

    /** @return 日時 */
    public String getNichijiDt() {
        return nichijiDt;
    }

    /** @param p 日時 */
    public void setNichijiDt(final String p) {
        this.nichijiDt = p;
    }

    /** 日付 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2})?")
    private String hidukeBi;

    /** @return 日付 */
    public String getHidukeBi() {
        return hidukeBi;
    }

    /** @param p 日付 */
    public void setHidukeBi(final String p) {
        this.hidukeBi = p;
    }

    /** 時刻 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,2}:[0-9]{1,2})?")
    private String jikokuHm;

    /** @return 時刻 */
    public String getJikokuHm() {
        return jikokuHm;
    }

    /** @param p 時刻 */
    public void setJikokuHm(final String p) {
        this.jikokuHm = p;
    }

    /** 時間 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,}:[0-9]{1,2})?")
    private String jikanTm;

    /** @return 時間 */
    public String getJikanTm() {
        return jikanTm;
    }

    /** @param p 時間 */
    public void setJikanTm(final String p) {
        this.jikanTm = p;
    }

    /** 数量 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,8}\\.?[0-9]{0,3}?)?")
    private String suryoQt;

    /** @return 数量 */
    public String getSuryoQt() {
        return suryoQt;
    }

    /** @param p 数量 */
    public void setSuryoQt(final String p) {
        this.suryoQt = p;
    }

    /** 通貨区分 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 2)
    private String tsukaKb;

    /** @return 通貨区分 */
    public String getTsukaKb() {
        return tsukaKb;
    }

    /** @param p 通貨区分 */
    public void setTsukaKb(final String p) {
        this.tsukaKb = p;
    }

    /** 受注単価 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,9}\\.?[0-9]{0,2}?)?")
    private String juchuPr;

    /** @return 受注単価 */
    public String getJuchuPr() {
        return juchuPr;
    }

    /** @param p 受注単価 */
    public void setJuchuPr(final String p) {
        this.juchuPr = p;
    }

    /** 受注金額 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,9}\\.?[0-9]{0,2}?)?")
    private String juchuAm;

    /** @return 受注金額 */
    public String getJuchuAm() {
        return juchuAm;
    }

    /** @param p 受注金額 */
    public void setJuchuAm(final String p) {
        this.juchuAm = p;
    }

    /** 発注単価 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,9}\\.?[0-9]{0,2}?)?")
    private String hachuPr;

    /** @return 発注単価 */
    public String getHachuPr() {
        return hachuPr;
    }

    /** @param p 発注単価 */
    public void setHachuPr(final String p) {
        this.hachuPr = p;
    }

    /** 発注金額 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,9}\\.?[0-9]{0,2}?)?")
    private String hachuAm;

    /** @return 発注金額 */
    public String getHachuAm() {
        return hachuAm;
    }

    /** @param p 発注金額 */
    public void setHachuAm(final String p) {
        this.hachuAm = p;
    }

    /** 削除フラグ */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 1)
    private String deleteF;

    /** @return 削除フラグ */
    public String getDeleteF() {
        return deleteF;
    }

    /** @param p 削除フラグ */
    public void setDeleteF(final String p) {
        this.deleteF = p;
    }

    /** ステータス区分 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 2)
    private String statusKb;

    /** @return ステータス区分 */
    public String getStatusKb() {
        return statusKb;
    }

    /** @param p ステータス区分 */
    public void setStatusKb(final String p) {
        this.statusKb = p;
    }

    /** 更新タイムスタンプ */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{13}|[0-9]{1,4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2}(T| )[0-9]{1,2}:[0-9]{1,2}(:[0-9]{1,2}(\\.[0-9]{3})?)?)?")
    @jp.co.golorp.emarf.validation.OptLock
    private String updateTs;

    /** @return 更新タイムスタンプ */
    @jp.co.golorp.emarf.validation.OptLock
    public String getUpdateTs() {
        return updateTs;
    }

    /** @param p 更新タイムスタンプ */
    @jp.co.golorp.emarf.validation.OptLock
    public void setUpdateTs(final String p) {
        this.updateTs = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");
    }
}
