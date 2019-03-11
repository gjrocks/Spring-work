package org.jzen.invoicing.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoice_client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private int id;
	
	
	@Column(name="client_id",nullable = false)
	private String clientId;
	
	@Column(name = "sys_org_id")
	private String sysOrgId;

	@Column(name = "enableLogin")
	private boolean isEnableLogin;

	@Column(name = "company_group_id")
	private String companyGroupId;

	@Column(name = "name")
	private String name;

	@Column(name = "sales_person")
	private String salesPerson;

	@Column(name = "url_code")
	private String urlCode;


	@Column(name = "division")
	private String division;

	@Column(name = "tswGroupEmailAddr")
	private String tswGroupEmailAddr;


	@Column(name = "clientGroupEmailAddr")
	private String clientGroupEmailAddr;


	@Column(name = "live_flag")
	private String liveFlag;


	@Column(name = "status")
	private Integer status;


	@Column(name = "can_delete_flag")
	private boolean isCanDeleteFlag;


	@Column(name = "logo_location")
	private boolean isLogoLocation;


	@Column(name = "visaExpiryReport")
	private boolean isVisaExpiryReport;


	@Column(name = "hidden")
	private boolean isHidden;


	@Column(name = "aTestClient")
	private boolean isATestClient;

	@Column(name = "volumeExpectedAnnually")
	private boolean isVolumeExpectedAnnualy;

	@Column(name = "volumeExpectedMonthly")
	private boolean isVolumeExpectedmonthly;

	@Column(name = "volumeExpectedWeekly")
	private boolean isVolumeExpectedWeekly;

	@Column(name = "save")
	private boolean isSave;

	@Column(name = "od_createdby")
	private String odCreatedBy;

	@Column(name = "od_updatedby")
	private String odUpdatedBy;

	@Column(name = "od_createdon")
	private Date odCreatedOn;

	@Column(name = "od_updatedon")
	private Date odupdatedOn;

	@Column(name = "migrate_id")
	private String migrateId;


	@Column(name = "create_id")
	private String createId;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSysOrgId() {
		return sysOrgId;
	}


	public void setSysOrgId(String sysOrgId) {
		this.sysOrgId = sysOrgId;
	}


	public boolean isEnableLogin() {
		return isEnableLogin;
	}


	public void setEnableLogin(boolean isEnableLogin) {
		this.isEnableLogin = isEnableLogin;
	}


	public String getCompanyGroupId() {
		return companyGroupId;
	}


	public void setCompanyGroupId(String companyGroupId) {
		this.companyGroupId = companyGroupId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSalesPerson() {
		return salesPerson;
	}


	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}


	public String getUrlCode() {
		return urlCode;
	}


	public void setUrlCode(String urlCode) {
		this.urlCode = urlCode;
	}


	public String getDivision() {
		return division;
	}


	public void setDivision(String division) {
		this.division = division;
	}


	public String getTswGroupEmailAddr() {
		return tswGroupEmailAddr;
	}


	public void setTswGroupEmailAddr(String tswGroupEmailAddr) {
		this.tswGroupEmailAddr = tswGroupEmailAddr;
	}


	public String getClientGroupEmailAddr() {
		return clientGroupEmailAddr;
	}


	public void setClientGroupEmailAddr(String clientGroupEmailAddr) {
		this.clientGroupEmailAddr = clientGroupEmailAddr;
	}


	public String getLiveFlag() {
		return liveFlag;
	}


	public void setLiveFlag(String liveFlag) {
		this.liveFlag = liveFlag;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public boolean isCanDeleteFlag() {
		return isCanDeleteFlag;
	}


	public void setCanDeleteFlag(boolean isCanDeleteFlag) {
		this.isCanDeleteFlag = isCanDeleteFlag;
	}


	public boolean isLogoLocation() {
		return isLogoLocation;
	}


	public void setLogoLocation(boolean isLogoLocation) {
		this.isLogoLocation = isLogoLocation;
	}


	public boolean isVisaExpiryReport() {
		return isVisaExpiryReport;
	}


	public void setVisaExpiryReport(boolean isVisaExpiryReport) {
		this.isVisaExpiryReport = isVisaExpiryReport;
	}


	public boolean isHidden() {
		return isHidden;
	}


	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}


	public boolean isATestClient() {
		return isATestClient;
	}


	public void setATestClient(boolean isATestClient) {
		this.isATestClient = isATestClient;
	}


	public boolean isVolumeExpectedAnnualy() {
		return isVolumeExpectedAnnualy;
	}


	public void setVolumeExpectedAnnualy(boolean isVolumeExpectedAnnualy) {
		this.isVolumeExpectedAnnualy = isVolumeExpectedAnnualy;
	}


	public boolean isVolumeExpectedmonthly() {
		return isVolumeExpectedmonthly;
	}


	public void setVolumeExpectedmonthly(boolean isVolumeExpectedmonthly) {
		this.isVolumeExpectedmonthly = isVolumeExpectedmonthly;
	}


	public boolean isVolumeExpectedWeekly() {
		return isVolumeExpectedWeekly;
	}


	public void setVolumeExpectedWeekly(boolean isVolumeExpectedWeekly) {
		this.isVolumeExpectedWeekly = isVolumeExpectedWeekly;
	}


	public boolean isSave() {
		return isSave;
	}


	public void setSave(boolean isSave) {
		this.isSave = isSave;
	}


	public String getOdCreatedBy() {
		return odCreatedBy;
	}


	public void setOdCreatedBy(String odCreatedBy) {
		this.odCreatedBy = odCreatedBy;
	}


	public String getOdUpdatedBy() {
		return odUpdatedBy;
	}


	public void setOdUpdatedBy(String odUpdatedBy) {
		this.odUpdatedBy = odUpdatedBy;
	}


	public Date getOdCreatedOn() {
		return odCreatedOn;
	}


	public void setOdCreatedOn(Date odCreatedOn) {
		this.odCreatedOn = odCreatedOn;
	}


	public Date getOdupdatedOn() {
		return odupdatedOn;
	}


	public void setOdupdatedOn(Date odupdatedOn) {
		this.odupdatedOn = odupdatedOn;
	}


	public String getMigrateId() {
		return migrateId;
	}


	public void setMigrateId(String migrateId) {
		this.migrateId = migrateId;
	}


	public String getCreateId() {
		return createId;
	}


	public void setCreateId(String createId) {
		this.createId = createId;
	}
	
	
	
}
