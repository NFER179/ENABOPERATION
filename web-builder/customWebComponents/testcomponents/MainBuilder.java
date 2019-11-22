package testcomponents;

import com.component.basic.structur.WebForm;
import com.component.basic.structur.WebInputTextField;
import com.component.basic.structur.WebTable;
import com.component.tag.WebHeader1;
import com.component.tag.WebTextField;

import builder.HTMLBuilder;
import enumeration.FormMethod;
import enumeration.FormTarget;

public class MainBuilder extends HTMLBuilder {
	
	private WebHeader1 wh1;
	private WebTextField wtf;
	private WebForm wf;
	private WebTable _wt;

	@Override
	public void InitComponents() {
		
		this.wh1 = new WebHeader1("Hola Mundo");
		
		this.wtf = new WebTextField();
		
		this.wf = new WebForm("", FormMethod.POST, FormTarget._self);
		this.wf.add(new WebInputTextField("Usuario: "));
		this.wf.add(new WebInputTextField("Pass: "));
		this.wf.setSubmit("Enviar", true);
		
		this._wt = new WebTable();
		this._wt.setHeader(new String[] {"label","textfield","link", "button"});
		this._wt.insertRow();
		
		add(this.wh1, this.wtf, this.wf);
	}
}