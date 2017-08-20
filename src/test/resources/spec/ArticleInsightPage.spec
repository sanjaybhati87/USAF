@import Regionalcommon.spec

@objects
	large-hero-component			   css		.wpg-slide.wpg-js-bg-paralaxy.cycle-slide.cycle-slide-active
	date-And-Auther                      xpath      //div[@class="wpg-mbhc-top"]/p
	date                               css      .short>span
	heading                            css      .wpg-mbhc-bottom>h1
	hedadingDescription                xpath     html/body/div[2]/div[2]/div[1]/div/div/div/div/div[2]/p
	text-section                       xpath     //div[@class="wrapper insight-article"]
    toolBox                            css       .wpg-icons-bar>ul
	download                           css        .wpg-download
	email                              css        .wpg-email
	print                              css        .wpg-print
    keyTermsBox                        css        .wpg-insight-sidebar
    keytermHeading                     css        .wpg-insight-sidebar>h2
    keyterms-*                           css        .wpg-insight-sidebar>ul>li
	text-on-page-*                     css        .container>p
	graph-descriptionText-*            css     .quote-content>h3
	funds-*                            xpath      //div[@class="container fund-container"]/div[@class="half"]
	fundSection                        xpath   //div[@class="wrapper focus-fund related-funds"]/div
	fundsectionHeading                 xpath    //h2[contains(text(),'Related funds')]
	viewAllFunds                       xpath     //a[contains(text(),' View all funds')]
	insightSection                     xpath     //div[@class="wrapper insights"]
	insightHeading                    xpath        //h2[contains(text(),'Related insights')]
	insights-*                        xpath         html/body/div[2]/div[5]/div[2]/div[1]/div/div
	more-isights                      xpath       //a[contains(text(),'Read more insights')]
	disclouserBox                     css         .col-xs-12.wpg-check-more-box-js.wpg-yes-box-more
	disclosuerHeading                 css         .col-xs-12.wpg-check-more-box-js.wpg-yes-box-more>h2
	viewFulldisclosure                css         .wpg-show-more-inset>strong
	disclosure-paragraph              css          .col-xs-12.wpg-check-more-box-js.wpg-yes-box-more>p
   	
	
	

	
	
=Hero component=
    @on *
	    large-hero-component:
		    below header 0px
			above text-section ~ 0px
			width 100% of screen/width
			
	    date-And-Auther:
		   centered horizontally inside large-hero-component 100px top 
		   below cookies-policy ~ 49px top
		   css font-size is "14px"
		   css font-family starts "BentonSans-Book"
		   
		heading:
		   centered horizontally inside large-hero-component 
		   below date-And-Auther 20px 
		   text contains "The Bumpy Road to China’s Economic Rebalancing"
		   css font-size is "34px"
		   css font-family starts "Mercury-DisplayRoman"
		hedadingDescription:
           centered horizontally inside large-hero-component 
		   below heading ~ 20px
		   css font-size is "16px"
		   css font-family starts "Mercury-DisplayItalic"
=Text Section=
    @on *		   
		text-section:
          below large-hero-component
          above fundSection  		  
          
		  
		toolBox :
           centered horizontally inside text-section 0px top	
           
		download:
            inside toolBox
			left-of email ~ 3px
			text is "DOWNLOAD"
			css font-size is "14px"
		    css font-family starts "BentonSans-Bold"
			
		email:
            inside toolBox
			left-of print ~ 3px
			text is "EMAIL"
			css font-size is "14px"
		    css font-family starts "BentonSans-Bold"
		print:
            inside toolBox
			right-of email ~ 3px
			text is "PRINT"
			css font-size is "14px"
		    css font-family starts "BentonSans-Bold"
        keyTermsBox:
            inside text-section 
			below toolBox
			
		keytermHeading:
            inside keyTermsBox ~ 25px top
			above keyterms-1
            text is "Key Takeaways"
            css font-size is "17px"
		    css font-family starts "BentonSans-Bold"			
		keyterms-*:
            inside keyTermsBox 
			below keytermHeading
            css font-size is "16px"
		    css font-family starts "Myriad-Pro-Regular"		
		text-on-page-* :
		    inside text-section 
			below toolBox
            css font-size is "14px"
		    css font-family starts "BentonSans-Book"
		graph-descriptionText-*:
		    inside text-section 
			below toolBox
            css font-size is "35px"
		    css font-family starts "Mercury-DisplayBoldItalic"
			
=Fund Section=
    @on *			
		fundSection:
            above insightSection 0px
            below text-section 
			width 100% of screen/width
			
		fundsectionHeading:
            centered horizontally inside fundSection 100px top
            text is "Related funds"	
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
            text is "VIEW ALL FUNDS"
            css font-size is "14px"
		    css font-family starts "BentonSans-Bold"

=Insight Section=
    @on *
        insightSection:			
			above disclouserBox ~ 64px
            below fundSection 0px
			width 100% of screen/width
		insightHeading:
            centered horizontally inside insightSection 100px top
            text is "RELATED INSIGHTS"	
            css font-size is "25px"
		    css font-family starts "BentonSans-Black"			
		insights-*:
		    @if ${isVisible("insights-*")}
               below insightHeading ~ 97px
			   width ~ 190px
			   height ~ 451px
			   above more-isights 
		@forEach [insights-*] as Insightitem, prev as previousInsightitem
            ${Insightitem}:
                right-of ${previousInsightitem} 0 to 1px
                aligned horizontally all ${previousInsightitem}	
		more-isights:
            inside insightSection 65px bottom
            text is "READ MORE INSIGHTS"
            css font-size is "14px"
		    css font-family starts "BentonSans-Bold"
=Disclosure Section=			
		disclouserBox:
            below insightSection 64px
			
		disclosuerHeading:
           inside disclouserBox 0px top
		   text is "DISCLOSURES"
           css font-size is "17px"
		   css font-family starts "BentonSans-Bold"
		   
		disclosure-paragraph:
           inside partly disclouserBox 
		   below disclosuerHeading
           css font-size is "14px"
		   css font-family starts "BentonSans-Book"   
            		   
		viewFulldisclosure:
           	inside disclouserBox 25px bottom	
		
           		
		