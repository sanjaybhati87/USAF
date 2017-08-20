@import Regionalcommon.spec

@objects
	large-hero-component			   css		.module-bg-header.wpg-js-bg-paralaxy                             
	heading                            css      .wpg-mbhc-top>h1
	hedadingDescription                css     .wpg-mbhc-top>p
	what-we-do-section                 xpath     //div[@class="module-header-text"][1]
	Paragraph-headings-*               css     .col-xs-12>h2
	paragraph-text-*                      css     .col-xs-12>p
	investment-section                  xpath   //div[@class="wrapper number-investment-section"]
	investment-heading                  xpath    //h2[@class="mercury"]
	investment-text                     xpath    //p[@class="mercury"]
	investment-items-*                   xpath    //div[@class="container col-md-10 center"]/div
	expertile-sections-*                 xpath    //div[@class="wrapper single-article"]/div
	icons-inside-expertile-*             xpath    //div[@class="icon-wrapper"]
	heading-icons-inside-expertile-*     css       .positioner>h3
	expertile-text-*                     css       .person-info>p
	expertile-images-*                     css       .span-table-cell.vertical-align-middle.wpg-left>a>span
	
	
	
	

	
	
=Hero component=
    @on *
	    large-hero-component:
		    below header 0px
			above what-we-do-section ~ 0px
			width 100% of screen/width
			
	    
		   
		heading:
		   centered horizontally inside large-hero-component  
		   text contains "Our fund capabilites"
		   css font-size is "50px"
		   css font-family starts "Mercury-DisplayRoman"
		hedadingDescription:
           centered horizontally inside large-hero-component 
		   below heading ~ 15px
		   css font-size is "21px"
		   css font-family starts "Mercury-DisplayRoman"
		   
		
             		
		   		
=What-we-do-section=
    @on *
        what-we-do-section:
           below large-hero-component ~ 0px
           above investment-section 
		Paragraph-headings-1: 
           inside what-we-do-section ~ 85px top
           css font-size is "25px"
		   css font-family starts "BentonSans-Black"
		   text is "WHAT WE DO BEST"
		paragraph-text-1: 
           inside what-we-do-section 
           css font-size is "14px"
		   css font-family starts "BentonSans-Book"
           text contains "We create carefully targeted investment funds to help our clients meet their investment objectives."
		
		Paragraph-headings-*:	
           css font-size is "25px"
		   css font-family starts "BentonSans-Black"
		   
		paragraph-text-*: 
           css font-size is "14px"
		   css font-family starts "BentonSans-Book"		
		   
=Investment Section=
    @on *
        investment-section:			
            below what-we-do-section 0px
			width 100% of screen/width
		investment-heading:
            centered horizontally inside investment-section 100px top
            text is "Number of investment professionals"	
            css font-size is "50px"
		    css font-family starts "Mercury-DisplayRoman"			
		investment-text:
            below investment-heading ~ 25px
			text is "Local knowledge + global collaboration = interpretation advantage"	
            css font-size is "21px"
		    css font-family starts "Mercury-DisplayRoman" 
		@forEach [investment-items-*] as investmentitem, prev as previousinvestmentitem
            ${investmentitem}:
                right-of ${previousinvestmentitem} 0 to 1px
                aligned horizontally all ${previousinvestmentitem}	
		investment-items-1:
            text contains "United States"
            

		investment-items-2:
            text contains "Europe"
			
		investment-items-3:
            text contains "Asia"	
			
=Expertile Section=
	@on * 
        @forEach [expertile-sections-*] as ExpertileSections, prev as previousExpertileSections
            ${ExpertileSections}:
                aligned vertically all ${previousExpertileSections}
		icons-inside-expertile-*:
            width ~ 50px
            height ~  50px
        heading-icons-inside-expertile-*:
            css font-size is "20px"
		    css font-family starts "BentonSans-Bold" 
		heading-icons-inside-expertile-1:
            text is "Fixed Income"	
		heading-icons-inside-expertile-2:
            text is "Equity"
		heading-icons-inside-expertile-3:
            text is "Alternatives"	
		heading-icons-inside-expertile-4:
            text is "Multi-asset"	
		expertile-text-*:
		    css font-size is "14px"
		    css font-family starts "BentonSans-Book" 
		expertile-images-*:
		    height ~ 320px
			width ~ 320px 