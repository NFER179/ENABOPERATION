package builder;

import com.component.Component;

import interfaces.WebBuilder;

public class HTMLBuilder extends Component implements WebBuilder {
	
	private String html = "<div>\n%s</div>";
	
	@Override
	public void InitComponents() {	
	}
	
	protected final void add(Component... components) {
		int iComponent;
		String sHtmlBody = "";
		
		for(iComponent = 0; iComponent < components.length; iComponent++) {
			sHtmlBody += "\t" + components[iComponent].getHtml().replaceAll("\n", "\n\t") + "\n";
		}
		
		this.html = String.format(this.html, sHtmlBody);
	}

	public String GetHTML() {
		return this.html;
	}
}