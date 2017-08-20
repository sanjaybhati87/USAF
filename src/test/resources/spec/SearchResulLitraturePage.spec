@import Regionalcommon.spec

@objects
    large-hero-component-top           css      .module-bg-header.wpg-js-bg-paralaxy
	textbox-large-hero-component-top   css      .wpg-mbhc-top
	heading-large-hero-component-top   css       .wpg-mbhc-top>h1
	text-large-hero-component-top      css       .wpg-mbhc-top>p	
	large-hero-component			   css		.wrapper.search-box
	page-search                             xpath     //h2[text()="Search"]
	reset                              css       .reset
	main-search                        css       .main-search
	search-icon                        css       .wpg-submit-search
	searchable-items-*                 xpath     //div[contains(@class,'box-wrapper')]
	result-count                       css       .wpg-padding-paragraph
	result-count-btCategory-*          css        .btn
	table                              xpath        html/body/div[2]/div[4]/div/div/div
	table-header-*                     css        .search-result-table>table>thead>tr>th
	table-rows-*                       css        .search-result-table>table>tbody>tr>td
	load-more                          xpath       //a[text()="Load more"]
	

	
	
=Hero component=
    @on *
	    large-hero-component-top:
		   above large-hero-component 0px
		   below header 0px
		   width 100% of screen/width
		   height 25% of screen/width
	
	    textbox-large-hero-component-top:
		   centered horizontally inside large-hero-component-top
		   width 71% of large-hero-component-top/width
		   
		heading-large-hero-component-top:
           centered horizontally inside textbox-large-hero-component-top
		   above text-large-hero-component-top 10 to 20 px
           text is "Fund Literature"
		   css font-size is "50px"
		   css font-family starts "Mercury-DisplayRoman"
		   
		text-large-hero-component-top:
		    centered horizontally inside textbox-large-hero-component-top
            text contains "Investors recently endured another bout of volatility in the China"
			css font-size is "21px"
		    css font-family starts "Mercury-DisplayRoman"
			
	    large-hero-component:
		    below large-hero-component-top 0px
			above result-count 0px
			width 100% of screen/width
			
	    page-search:
		   inside large-hero-component 
		   text is "Search"
		   css font-size is "20px"
		   css font-family starts "Mercury-DisplayRoman"
		reset:
		   inside large-hero-component 
		   below cookies-policy ~ 384px top
		   text is "RESET ALL"
		   right-of page-search 22px
		   css font-size is "12px"
		   css font-family starts "BentonSans-Book"
		main-search:
           centered horizontally inside large-hero-component 100px top
		   width 64% of screen/width
		   aligned vertically  left page-search
		   height 44px
		search-icon:
          right-of main-search 0px
          height 44px
		  aligned horizontally  all main-search
		  aligned vertically  right searchable-items-5
		  
		searchable-items-* :
           height 52 px	
           below main-search
           inside large-hero-component
		@forEach [searchable-items-*] as searchItem, prev as previoussearchItem
            ${searchItem}:
                right-of ${previoussearchItem} 0 to 1px
                aligned horizontally all ${previoussearchItem}
		result-count:
            below large-hero-component 0px
			
		result-count-btCategory-*:
            height 47px
            below result-count
		@forEach [result-count-btCategory-*] as resultCountCategory, prev as previousresultCountCategory
            ${resultCountCategory}:
                right-of ${previousresultCountCategory} 0 to 1px
                aligned horizontally all ${previousresultCountCategory}
		load-more:
		    centered horizontally inside screen 
			text is "LOAD MORE"
			css font-size is "14px"
		    css font-family starts "BentonSans-Bold"
           		
		table:
		    width 71% of screen/width
		table-header-*:
            inside table  33px top
			height 49px
		table-rows-*:
            height 51px		
		@forEach [table-header-*] as tablecoloumn, prev as previoustablecoloumn
            ${tablecoloumn}:
                right-of ${previoustablecoloumn} 0px
                aligned horizontally all ${previoustablecoloumn}	
			