

@objects
	large-hero-component			   css		.wpg-slide.wpg-js-bg-paralaxy.cycle-slide.cycle-slide-active
	date-And-Auther                    xpath      //div[@class="wpg-mbhc-top"]/p
	date                               css      .short>span
	heading                            css      .wpg-mbhc-bottom>h1
	hedadingDescription                xpath     html/body/div[2]/div[2]/div[1]/div/div/div/div/div[2]/p
	filter-section                     css       .wrapper.search-box
	filter-text                        css      .container.wpg-fix-c12>h2
	reset-text                         css      .reset
	main-search-box                    css        .main-search
	search-icon                        css      .wpg-submit-search
	search-filter-boxes-*              css       .wpg-plugin-select-simulate
	search-box-text-*                  css        .wpg-plugin-select-simulate-selection>strong
	asset-class                        css       .container>p
	asset-class-category               css       .tag
	insightHeading                    xpath        //h2[contains(text(),'Our insights')]
	insight-section                   xpath        //div[@class="wrapper insights"]
	insights-*                        css          .padding.wpg-columns-3
	more-isights                      xpath         //a[contains(text(),'LOAD More Insights')]
	
	
	

	
	
=Hero component=
    @on desktop
	    large-hero-component:
		    below header 0px
			above filter-section  0px
			width 100% of screen/width
			
	    date-And-Auther:
		   centered horizontally inside large-hero-component 100px top 
		   below cookies-policy ~ 14px top
		   css font-size is "14px"
		   css font-family starts "BentonSans-Book"
		   
		heading:
		   centered horizontally inside large-hero-component 
		   below date-And-Auther 20px 
		   text contains "The Bumpy Road to China�s Economic Rebalancing"
		   css font-size is "34px"
		   css font-family starts "Mercury-DisplayRoman"
		hedadingDescription:
           centered horizontally inside large-hero-component 
		   below heading ~ 20px
		   css font-size is "16px"
		   css font-family starts "Mercury-DisplayItalic"
		   		
=Filter Section=
    @on desktop
        filter-section:
           below large-hero-component  0px
           above insight-section 
		filter-text: 
           inside filter-section 33px top
           aligned vertically left main-search-box
           css font-size is "20px"
		   css font-family starts "Mercury-DisplayRoman"
		   text is "Filters"
		reset-text: 
           inside filter-section 39px top
           css font-size is "12px"
		   css font-family starts "BentonSans-Book"
           text is "RESET ALL"
		main-search-box:
           inside filter-section 
		   below filter-text
		search-icon:
           inside filter-section
           right-of main-search-box 0px
		search-filter-boxes-*:
           below main-search-box
           height ~ 42px
        @forEach [search-filter-boxes-*] as searchItem, prev as previoussearchItem
            ${searchItem}:
                right-of ${previoussearchItem} 20 to 22px
                aligned horizontally all ${previoussearchItem}	
		search-box-text-* :
            css font-size is "14px"
		    css font-family starts "BentonSans-Medium"
			

=Insight Section=
    @on desktop
        insight-section:			
            below filter-section ~ 142px
			width 100% of screen/width
		insightHeading:
            centered horizontally inside insight-section 100px top
            text is "OUR INSIGHTS"	
            css font-size is "25px"
		    css font-family starts "BentonSans-Black"			
		insights-*:
            below insightHeading 
			width ~ 322px
			height ~ 422px
			above more-isights
		@for [ 1,2 ] as index
            insights-${index}:		
                left-of insights-${index + 1} 0 to 1px
                aligned horizontally all insights-${index + 1}	
		more-isights:
            inside insight-section ~ 65px bottom
            text is "LOAD MORE INSIGHTS"
            css font-size is "14px"
		    css font-family starts "BentonSans-Bold"



=Hero component=
    @on desktop
	    large-hero-component:
		    below header 0px
			above filter-section  0px
			width 100% of screen/width
			
	    date-And-Auther:
		   centered horizontally inside large-hero-component 100px top 
		   below cookies-policy ~ 14px top
		   css font-size is "14px"
		   css font-family starts "BentonSans-Book"
		   
		heading:
		   centered horizontally inside large-hero-component 
		   below date-And-Auther 20px 
		   text contains "The Bumpy Road to China�s Economic Rebalancing"
		   css font-size is "34px"
		   css font-family starts "Mercury-DisplayRoman"
		hedadingDescription:
           centered horizontally inside large-hero-component 
		   below heading ~ 20px
		   css font-size is "16px"
		   css font-family starts "Mercury-DisplayItalic"
		   		
=Filter Section=
    @on tab
        filter-section:
           below large-hero-component  0px
           above insight-section 
		filter-text: 
           inside filter-section 32px top
           aligned vertically left main-search-box
           css font-size is "19.6px"
		   css font-family starts "Mercury-DisplayRoman"
		   text is "Filters"
		reset-text: 
           inside filter-section 38px top
           css font-size is "12px"
		   css font-family starts "BentonSans-Book"
           text is "RESET ALL"
		main-search-box:
           inside filter-section 
		   below filter-text
		   
		search-icon:
           inside filter-section
           right-of main-search-box 0px
           
		search-filter-boxes-*:
           below main-search-box
           height ~ 42px
    	
		search-box-text-* :
            css font-size is "14px"
		    css font-family starts "BentonSans-Medium"
			

=Insight Section=
    @on tab
        insight-section:			
            below filter-section ~ 142px
			width 100% of screen/width
		insightHeading:
            centered horizontally inside insight-section 100px top
            text is "OUR INSIGHTS"	
            css font-size is "25px"
		    css font-family starts "BentonSans-Black"			
		insights-*:
            below insightHeading 
			width ~ 698px
			height ~ 417px
			above more-isights
		@for [ 1,2 ] as index
            insights-${index}:		
                
                aligned vertically left insights-${index + 1}	
		more-isights:
            inside insight-section ~ 65px bottom
            text is "LOAD MORE INSIGHTS"
            css font-size is "14px"
		    css font-family starts "BentonSans-Bold"
		    
		    



=Hero component=
    @on mobile
	    large-hero-component:
		    
			above filter-section  0px
			width 100% of screen/width
			
	    date-And-Auther:
		   centered horizontally inside large-hero-component 100px top 
		  
		   css font-size is "14px"
		   css font-family starts "BentonSans-Book"
		   
		heading:
		   centered horizontally inside large-hero-component 
		   below date-And-Auther 20px 
		  
		   css font-size is "34px"
		   css font-family starts "Mercury-DisplayRoman"
		   
		hedadingDescription:
           centered horizontally inside large-hero-component 
		   below heading ~ 20px
		   css font-size is "16px"
		   css font-family starts "Mercury-DisplayItalic"
		   		
=Filter Section=
    @on mobile
        filter-section:
           below large-hero-component  0px
           above insight-section 
		filter-text: 
           inside filter-section 33px top
           
           css font-size is "19.6px"
		   css font-family starts "Mercury-DisplayRoman"
		   text is "Filters"
		reset-text: 
           inside filter-section 39px top
           css font-size is "12px"
		   css font-family starts "BentonSans-Book"
           text is "RESET ALL"
		main-search-box:
           inside filter-section 
		   below filter-text
		   
		search-icon:
           inside filter-section
           right-of main-search-box 0px
           
		search-filter-boxes-*:
           below main-search-box
           height ~ 42px
    	
		search-box-text-* :
            css font-size is "14px"
		    css font-family starts "BentonSans-Medium"
			

=Insight Section=
    @on mobile
        insight-section:			
            below filter-section ~ 105px
			width 100% of screen/width
		insightHeading:
            centered horizontally inside insight-section 100px top
            text is "OUR INSIGHTS"	
            css font-size is "20px"
		    css font-family starts "BentonSans-Black"			
		insights-*:
            below insightHeading 
			width ~ 322px
			height ~ 425px
			above more-isights
		@for [ 1,2 ] as index
            insights-${index}:		
                
                aligned vertically left insights-${index + 1}	
		more-isights:
            
            text is "LOAD MORE INSIGHTS"
            css font-size is "14px"
		    css font-family starts "BentonSans-Bold"
		