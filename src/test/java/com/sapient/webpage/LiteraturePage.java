/**
 * 
 */
package com.sapient.webpage;





import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.sapient.core.TestLogging;
import com.sapient.webelements.HtmlElement;
import com.sapient.webelements.LabelElement;
import com.sapient.webelements.LinkElement;

/**
 * @author ssi248
 *
 */
public class LiteraturePage extends WebBasePage {

	/**
	 * @param driver
	 * @param pagename
	 */
	
	private static final LabelElement viewAllLitratureLink = new LabelElement("View all Litrture link", parser.getLocator("viewAllLitrature"));
	private static final LinkElement allDocumentType = new LinkElement("Document Options from drop down",parser.getLocator("documentTypeFilter"));
	private static final LabelElement refrshAll = new LabelElement("Refresh all options",parser.getLocator("refreshAll"));
	private static final LabelElement selectedFilterText = new LabelElement("Selected filter text",parser.getLocator("selectedFilterText"));
	private static final LabelElement dropdownIcon = new LabelElement("DropDown icon to show and hide list",parser.getLocator("dropdownIcon"));
	private static final LinkElement documentTypeInTable = new LinkElement("Options from drop down",parser.getLocator("documentTypeInTable"));
	private static final LinkElement allAssetType = new LinkElement("Asset Options from drop down",parser.getLocator("assetClass_filter"));
	private static final LabelElement AssetdropdownIcon = new LabelElement("DropDown icon to show and hide list",parser.getLocator("assetClass_dropdownIcon"));
	private static final LinkElement AssetTypeInTable = new LinkElement("Options from drop down",parser.getLocator("asstClassTypeInTable"));
	
	public LiteraturePage(WebDriver driver) {
		super(driver, "LitraturePage");
		// TODO Auto-generated constructor stub
	
	}
	
	public LiteraturePage clickOnAllLitratureLink()
	{
		mouseHoverAndClick(LitratureLink, viewAllLitratureLink);
		return this;
	}
	
	public boolean filterByDocumnetType()
	{
		
		boolean flag=true;
		List<WebElement> docsList=allDocumentType.getAllElements();
		for(WebElement docs:docsList )
		{
			
			if(!docs.isDisplayed())
			{
			clickByJavaScript(dropdownIcon);
			pauseExecutionFor(1000);
			}
			String s1=docs.getText();
			System.out.println(docs.getText());

			clickByJavaScript(docs);
			pauseExecutionFor(1000);
			List<WebElement> documentsInTable = documentTypeInTable.getAllElements();
			if(documentsInTable.size()>0)
			{
			for(WebElement tabledocument:documentsInTable)
			{
				System.out.println(tabledocument.getText());
				String s2= tabledocument.getText();
				if(!s1.equalsIgnoreCase(s2))
				{
					TestLogging.logWebStep(null, "Record in table contains file type"+s2+"While user has selected document type"+s1, true);
					flag=false;
					break;
				}
				
				if(!flag)
					break;
			}
			}
			clickByJavaScript(refrshAll);
			clickByJavaScript(selectedFilterText);
			if(!flag)
				break;
			
		}

		return flag;
	}
	
	public boolean filterByAssetType()
	{
		
		boolean flag=true;
		List<WebElement> assetList=allAssetType.getAllElements();
		for(WebElement asset:assetList )
		{
			
			if(!asset.isDisplayed())
			{
			clickByJavaScript(AssetdropdownIcon);
			pauseExecutionFor(1000);
			}
			String s1=asset.getText();
			System.out.println(asset.getText());

			clickByJavaScript(asset);
			pauseExecutionFor(1000);
			List<WebElement> assetInTable = AssetTypeInTable.getAllElements();
			if(assetInTable.size()>0)
			{
			for(WebElement tableAsset:assetInTable)
			{
				System.out.println(tableAsset.getText());
				String s2= tableAsset.getText();
				if(!s1.equalsIgnoreCase(s2))
				{
					flag=false;
					break;
				}
				
				if(!flag)
					break;
			}
			}
			clickByJavaScript(refrshAll);
			clickByJavaScript(selectedFilterText);
			if(!flag)
				break;
			
		}

		return flag;
	}

}
