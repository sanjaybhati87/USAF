@import Regionalcommon.spec

@objects
	large-hero-component			   css		.wrapper.search-box
	page-search                             xpath     //h2[text()="Search"]
	reset                              css       .reset
	main-search                        css       .main-search
	search-icon                        css       .wpg-submit-search
	searchable-items-*                 xpath     //div[contains(@class,'box-wrapper')]
	result-count                       css       .wpg-padding-paragraph
	result-count-btCategory-*          css        .btn
	capability-box                     css        .container.article.entry
	capability-heading-*               css        .section-header
	capability-text                    css         .wpg-middle>p
	person-detail-section              css         .container.article.person
	person-image                       css         .left.half.image-wrapper>img
	person-section-heading             xpath       //h2[contains(text(),'First name, last name')]
	exprince-*                         css         .mercury.block-text
	number-*                           css         .number
	exprince-paragraph                 css         .left.half>p
	managing-through-*                 css          .right.three-fourth
	managing-through-header-*          xpath          //h2[contains(text(),'Managing through change')]
	managing-through-text-*            css          .right.three-fourth>p
	managing-through-date-*            css          .date.mercury
	complex-fund-info                  css           .wl-complexfund__info.js-complexFundInfo
	complex-fund-info-initail          css           .wl-complexfund__initials.wl-complexfund__initials--green
	complex-fund-info-titel                 css           .wl-complexfund__title
	complex-fund-info-performance-*         css           .wl-complexfund__title
	complex-fund-info-performance-value-*    css         .wl-complexfund__details
	complex-fund-info-documents-*            css        .wl-complexfund__docs>a
	risk-pages                               css        .wl-complexfund__risk>p
	risk-category                            css         .wl-complexfund__risk>footer>span
	load-more                                xpath         //a[text()="Load more"]
	

	
	
=Hero component=
    @on *
	    large-hero-component:
		    below header 0px
			above result-count 0px
			width 100% of screen/width
			
	    page-search :
		   inside large-hero-component 
		   below cookies-policy ~ 27px top
		   text is "Search"
		   css font-size is "20px"
		   css font-family starts "Mercury-DisplayRoman"
		reset:
		   inside large-hero-component 
		   below cookies-policy ~ 33px top
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
		capability-box:
            above person-detail-section
			aligned vertically  all person-detail-section
            			
		capability-heading-*:
		    css font-size is "12px"
		    css font-family starts "BentonSans-Black"
		capability-text:
		    inside capability-box
			css font-size is "14px"
		    css font-family starts "BentonSans-Book"
			
		person-detail-section:
            below capability-box
			aligned vertically  right managing-through-1
		person-image:
            inside person-detail-section
            width 134px
            height 134px
		
		exprince-1:
            left-of exprince-2 	0 to 1px
            aligned horizontally all exprince-2 
		exprince-2:
            right-of exprince-1 0 to 1px
            aligned horizontally all exprince-1 	
				
		@forEach [number-*] as Number, prev as previouNumber
            ${Number}:
                right-of ${previouNumber} 0 to 1px
                aligned horizontally all ${previouNumber}		
        exprince-paragraph:
            right-of  exprince-2  1px
			css font-size is "12px"
		    css font-family starts "BentonSans-Book"
        @forEach [managing-through-* ] as managingthrough , prev as previoumanagingthrough
            ${managingthrough}:
                below ${previoumanagingthrough} 5 to 10px
                aligned vertically all ${previoumanagingthrough}
    			
		managing-through-text-*:
			css font-size is "14px"
		    css font-family starts "BentonSans-Book"
		load-more:
		    centered horizontally inside screen 
			text is "LOAD MORE"
			css font-size is "14px"
		    css font-family starts "BentonSans-Bold"
           		
		