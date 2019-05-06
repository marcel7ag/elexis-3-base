package ch.elexis.base.ch.icd10;

import java.util.List;

import ch.elexis.core.jpa.entities.ICD10;
import ch.elexis.core.jpa.model.adapter.AbstractIdDeleteModelAdapter;
import ch.elexis.core.jpa.model.adapter.mixin.ExtInfoHandler;
import ch.elexis.core.model.IDiagnosisTree;
import ch.elexis.core.model.IXid;
import ch.elexis.core.model.Identifiable;
import ch.elexis.core.model.WithExtInfo;
import ch.elexis.core.services.holder.XidServiceHolder;

public class Icd10Diagnosis
		extends AbstractIdDeleteModelAdapter<ch.elexis.core.jpa.entities.ICD10>
		implements IDiagnosisTree, WithExtInfo, Identifiable {
	
	private ExtInfoHandler extInfoHandler;
	
	public static final String CODESYSTEM_NAME = "ICD-10";
	
	public Icd10Diagnosis(ICD10 entity){
		super(entity);
		extInfoHandler = new ExtInfoHandler(this);
	}
	
	@Override
	public String getDescription(){
		return getEntity().getText();
	}
	
	@Override
	public void setDescription(String value){
		getEntity().setText(value);
	}
	
	@Override
	public String getCodeSystemName(){
		return CODESYSTEM_NAME;
	}
	
	@Override
	public String getCode(){
		return getEntity().getCode();
	}
	
	@Override
	public void setCode(String value){
		getEntity().setCode(value);
	}
	
	@Override
	public String getText(){
		return getEntity().getText();
	}
	
	@Override
	public void setText(String value){
		getEntity().setText(value);
	}
	
	@Override
	public Object getExtInfo(Object key){
		return extInfoHandler.getExtInfo(key);
	}
	
	@Override
	public void setExtInfo(Object key, Object value){
		extInfoHandler.setExtInfo(key, value);
	}
	
	@Override
	public IDiagnosisTree getParent(){
		String parentCode = getEntity().getParent();
		if (parentCode != null && "NIL".equals(parentCode)) {
			return ModelUtil.loadDiagnosisWithCode(parentCode).orElse(null);
		}
		return null;
	}
	
	@Override
	public void setParent(IDiagnosisTree value){
		getEntity().setParent(value.getId());
	}
	
	@Override
	public List<IDiagnosisTree> getChildren(){
		return ModelUtil.loadDiagnosisWithParent(getId());
	}
	
	@Override
	public String getLabel(){
		return getCode() + " " + getText();
	}
	
	@Override
	public boolean addXid(String domain, String id, boolean updateIfExists){
		return XidServiceHolder.get().addXid(this, domain, id, updateIfExists);
	}
	
	@Override
	public IXid getXid(String domain){
		return XidServiceHolder.get().getXid(this, domain);
	}
}
