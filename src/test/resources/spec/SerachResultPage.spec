@import Regionalcommon.spec

@objects
	large-hero-component			   css		.wrapper.search-box
	search                             xpath     //h2[text()="Search"]
	reset                              css       .reset
	main-search                        css       .main-search
	search-icon                        css       .wpg-submit-search
	searchable-items-*                 xpath     //div[contains(@class,'box-wrapper')]
	result-count                       css       .wpg-padding-paragraph
	result-count-btCategory-*          css        .btn
	capability-box                     css        .container.article.entry
	capability-heading-*               css        .section-header
	capability-text                    css         .wpg-middle>p
	person-detail-section              css         .wpg-middle>p
	person-image                       css         .left.half.image-wrapper>img
	person-section-heading             xpath       //h2[contains(text(),'First name, last name')]
	exprince-*                         css         .mercury.block-text
	exprince-number-*                  css         .number
	exprince-paragraph                 css         .left.half>p
	managing-through-*                 css          .right.three-fourth
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
			width 100% screen/width
			
	    search:
		   inside large-hero-component 
		   below cookies-policy 0px top
		   text is "Search"
		   css font-size is "20px"
		   css font-family starts "Mercury-DisplayRoman"
		reset:
		   inside large-hero-component 
		   below cookies-policy 0px top
		   text is "Search"
		   right-of search 100px
		   css font-size is "20px"
		   css font-family starts "Mercury-DisplayRoman"
		main-search:
           centered horizontally inside large-hero-component 100px top
		   width 50% screen/width
		   aligned vertically  left search
		   height 44px
		search-icon:
          left-of main-search 0px
          height 44px
		  aligned horizontally  all main-search
		  aligned vertically  right searchable-items-5
		  
		searchable-items-* :
           height 42 px	
           below main-search
           inside large-hero-component
		@forEach [searchable-items-*] as searchItem, prev as previoussearchItem
            ${searchItem}:
                right-of ${previoussearchItem} 5 to 10px
                aligned horizontally all ${previoussearchItem}
		result-count:
            below large-hero-component 0px
			
		result-count-btCategory-*
            height 47px
            below result-count
		@forEach [result-count-btCategory-*] as resultCountCategory, prev as previousresultCountCategory
            ${resultCountCategory}:
                right-of ${previousresultCountCategory} 5 to 10px
                aligned horizontally all ${previousresultCountCategory}
		capability-box:
            above person-detail-section
			aligned vertically  all person-detail-section
            			
		capability-heading-*:
		    css font-size is "20px"
		    css font-family starts "Mercury-DisplayRoman"
		capability-text:
		    inside capability-box
			css font-size is "20px"
		    css font-family starts "Mercury-DisplayRoman"
			
		person-detail-section:
            below capability-box
			aligned vertically  right managing-through-*
		person-image:
            inside person-detail-section
            width 134px
            height 134px
		@forEach [exprince-*] as exprinceitem, prev as previouexprinceitem
            ${exprinceitem}:
                right-of ${previouexprinceitem} 5 to 10px
                aligned horizontally all ${previouexprinceitem}
		@forEach [exprince-number-*] as exprinceNumber, prev as previouexprinceNumber
            ${exprinceNumber}:
                right-of ${previouexprinceNumber} 5 to 10px
                aligned horizontally all ${previouexprinceNumber}		
        exprince-paragraph:
            right-of  exprince-2  20px
			css font-size is "20px"
		    css font-family starts "Mercury-DisplayRoman"
        @forEach [managing-through-* ] as managingthrough , prev as previoumanagingthrough
            ${managingthrough}:
                below ${previoumanagingthrough} 5 to 10px
                aligned vertically all ${previoumanagingthrough}
    			
		managing-through-text-*:
			css font-size is "20px"
		    css font-family starts "Mercury-DisplayRoman"
		load-more:
		    entered horizontally inside screen 
			text is "Load more"
			css font-size is "20px"
		    css font-family starts "Mercury-DisplayRoman"
           		
		