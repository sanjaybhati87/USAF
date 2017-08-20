@import Regionalcommon.spec

@objects
		
		HeaderBackgroundImage				css				.module-bg-header-type-2.wpg-js-bg-paralaxy
		HeaderFundTitle						css				.wpg-mbhc-top>h1
		HeaderFundText						css				.wpg-mbhc-top>p
		HeaderTextContainer					css				.col-xs-6.col-sm-6.col-md-3>h4
		HeaderNumberContainer				css				.col-xs-6.col-sm-6.col-md-3>p
		FixedIncomeBackground-*				css				.module-header-text
		TextTitle-*							css				.col-xs-12>h2
		FixedIncomeBrochure					css				.cta.blue.download
		VideoBackground						css				.module-circle-header-text
		Video								css				.col-xs-12.col-sm-5.wpg-image-box>a>img
		funds-*                            xpath      		//div[@class="container fund-container"]/div[@class="half"]
		fundSection                        xpath  			//div[@class="wrapper focus-fund related-funds"]/div
		fundsectionHeading                 css   			.section-header-white
		viewAllFunds                       css    			.cta.white
		insightSection                     xpath     		//div[@class="wrapper insights"]
		TableTopBox-*						css				.table.capabilites>table>thead>tr>th
		FundAttributeTitle-*				xpath				//tr[@class="wpg-table-divider"]/td[1]
		FundAttributeValue-*				xpath			//div[@class="table capabilites"]/table/tbody/tr[2]/td
		insightSection                     css     			.wrapper.insights
		insightHeading                     css       		.section-header
		insights-*                        css         		 .padding.wpg-columns-3
		more-isights                      xpath      	 //div[@class="animated-wrapper"]/div[9]/div[3]/a
		disclouserBox                     css         .col-xs-12.wpg-check-more-box-js
		disclosuerHeading                 css         .col-xs-12.wpg-check-more-box-js>h2
		viewFulldisclosure                css         .wpg-show-more-inset>strong
		disclosure-paragraph              css          .col-xs-12.wpg-check-more-box-js>p
		
		
		FocusFundTitle							css			.section-header-white
		
		FocusFundBox-*							css				.fund-item
		FocusFundSmallImage-*					xpath			//div[@class="half"]/div/div[@class="wpg-ico-container"]
		FocusFundBoxTitle-*						css				.fund-header>h2
		FocusFundBoxAmount-*					css				.fund-header>span
		
		FocusFundBoxText-*						css				.fund-header>p
		FocusFundBoxGreyLine-*					css				.little-grey-string
		ShareClassText-*						css				.wrapper>span
		ShareClassSelectBox-*					css				.wpg-plugin-select-simulate
		FundBody-*								css				.additional-info
		
		
		
		
		
		
		
		
		
		
=Header=
		
		HeaderBackgroundImage:
					height 378px
					width 1349px
					
					
		HeaderFundTitle:
					height 55px
					css font-size is "50px" 
					css font-family contains "Mercury-DisplayRoman" 
					
		HeaderFundText:
		
					width 800px
					css font-size is "21px" 
					css font-family contains "Mercury-DisplayRoman" 
					
					
		HeaderTextContainer:
		
					height 73px
					width  158px
					css font-size is "14px" 
					css font-family contains "Mercury-DisplayItalic" 
					below HeaderFundText 52px
					
		HeaderNumberContainer:
		
					height 67px
					width  158px
					css font-size is "30px" 
					css font-family contains "BentonSans-Book" 
					below HeaderFundText 125px
		
		
=Body=

		FixedIncomeBackground-1:
					height 417px
					width  1349px
					below HeaderTextContainer 67px
					
					
		FixedIncomeTitle-*:
				css font-size is "25px" 
				css font-family contains "BentonSans-Black" 
				
		FixedIncomeBrochure:
				height 42px
				width	320px
				css font-size is "14px" 
				css font-family contains "BentonSans-Bold" 
				
		VideoBackground:
					height 472px
					width  1349px
					css font-size is "14px" 
					css font-family contains "BentonSans-Book" 
					below FixedIncomeBrochure 85px
					
		Video:
					height 300px
					width  300px
					below VideoBackground -386px
					
					
=Fund Section=
    @on *			
		fundSection:
            above insightSection 1343px
            
			width 100% of screen/width
			
		fundsectionHeading:
            centered horizontally inside fundSection 100px top
            text is "Focused fixed income funds"	
            css font-size is "50px"
		    css font-family starts "Mercury-DisplayRoman"			
		funds-*:
            below fundsectionHeading 60px
			width ~ 380px
			height ~ 440px
			above viewAllFunds
		@forEach [funds-*] as funditem, prev as previousfunditemAuthorImage
            ${funditem}:
                right-of ${previousfunditemAuthorImage} 0 to 1px
                aligned horizontally all ${previousfunditemAuthorImage}	
                
		viewAllFunds:
            inside fundSection 60px bottom
            text is "VIEW ALL FIXED INCOME FUNDS"
            css font-size is "14px"
		    css font-family starts "BentonSans-Bold"
		    
=Fund Properties=

		TableTopBox-1:
					height 92px
					width  386px	    
			
			
           	
        @for [2,3,4] as index
			TableTopBox-${index}:
					height 92px
					width  193px
					css font-size is "11px"
			  		css font-family starts "BentonSans-Bold"
			  		aligned horizontally top TableTopBox-1
			  		
		FundAttributeTitle-*:
			 		height 65px
			 		width 386px
			 		css font-size is "16px"
			  		css font-family starts "BentonSans-Bold"
			  		aligned vertically left TableTopBox-1
			  		
		FundAttributeValue-1:
					width  386px
			  		height 92px
					aligned vertically left TableTopBox-1  
					
		@for [2,3,4] as index
			FundAttributeValue-${index}:
					height 59px
					width 193px
					css font-size is "12px"
			  		css font-family starts "BentonSans-Bold"
			  		aligned horizontally top TableTopBox-1
			  		
=Insight Section=
    @on *
        insightSection:			
			above disclouserBox ~ 64px
            below fundSection 1343px
			width 100% of screen/width
			
		insightHeading:
            centered horizontally inside insightSection 100px top
            
            css font-size is "25px"
		    css font-family starts "BentonSans-Black"	
		    
		insights-*:
            below insightHeading ~ 101px
			width ~ 337px
			height ~ 403px
			above more-isights 
			
		@forEach [insights-*] as Insightitem, prev as previousInsightitem
            ${Insightitem}:
                height 403px
                width 337px
                aligned horizontally all ${previousInsightitem}	
                
		more-isights:
            inside insightSection 66px bottom
            css font-size is "14px"
		    css font-family starts "BentonSans-Bold"
		    
		  
		    
		   
		   
= Focus Fixed Income Fund=

	FocusFundTitle:
			height 70px
			
			css font-size is "50px"
			css font-family starts "Mercury-DisplayRoman" 
			
	
			
			
			
			
			
	FocusFundBox-*:
	
			height 440px
			width  310px
			
			
	FocusFundSmallImage-*:
		height 35px
		width 35px
		
		
		
		
		
	@for [1,2] as index
		FocusFundBox-${index}:
			below FocusFundTitle 60px
			
		FocusFundSmallImage-${index}:
			inside FocusFundBox-${index} 0px top left 
			
		FocusFundBoxTitle-${index}:
			inside FocusFundBox-${index} 47px left,36px top
			css font-size is "20px"
			css font-family starts "BentonSans-Black" 
			
		FocusFundBoxAmount-${index}:
			inside FocusFundBox-${index} 1px left
			css font-size is "12px"
			css font-family starts "Mercury-DisplayRoman" 
			
		FocusFundBoxText-${index}:
			inside FocusFundBox-${index} 1px left
			css font-size is "12px"
			css font-family starts "BentonSans-Book" 
			
		FocusFundBoxGreyLine-${index}:
			width 80px
			below FocusFundBoxText-${index} ~30px
			
		ShareClassText-${index}:
			below FocusFundBox-${index} -233px
			css font-size is "12px"
			css font-family starts "Mercury-DisplayRoman"
			
		ShareClassSelectBox-${index}:
			height 43px
			width 274px
			below ShareClassText-${index} 12px
			css font-size is "22px"
			css font-family starts "BentonSans-Book"
			
		FundBody-${index}:
			height 150px
			width 103px
			below ShareClassText-${index} 69px
		    		
		
				
		
	
	
				

		
					
					
		