package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.DIgibankEntity;
import model.Digibank;
import service.DigibankEJB;

@ManagedBean(name = "digibankcontroller")
@SessionScoped
public class DigibankController {

	@EJB
    private DigibankEJB digibankEJB;
	
	@ManagedProperty(value="#{digibank}")
	private Digibank digibank;
	
	private List<DIgibankEntity> transactionsList = new ArrayList<>();

	public List<DIgibankEntity> getTransactionsList() {
		transactionsList = digibankEJB.getAllTransactions();
		return transactionsList;
	}

	public String viewEmployee() {
		return "transactionsList.xhtml";
	}
	
	public String addNewTransaction()
	{
		digibankEJB.addNew(digibank.getEntity());
		return "transactionsList.xhtml";
	}

	public Digibank getDigibank() {
		return digibank;
	}

	public void setDigibank(Digibank digibank) {
		this.digibank = digibank;
	}

	public DigibankEJB getDigibankEJB() {
		return digibankEJB;
	}

	public void setDigibankEJB(DigibankEJB digibankEJB) {
		this.digibankEJB = digibankEJB;
	}

	public void setTransactionsList(List<DIgibankEntity> transactionsList) {
		this.transactionsList = transactionsList;
	}
	
	
}
