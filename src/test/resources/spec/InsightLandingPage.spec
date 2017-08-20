@import Regionalcommon.spec

@objects
    large-hero-component           css      .container-fluid.small.center-block.row-fluid>div
	heading-large-hero-component   css       .container-fluid.small.center-block.row-fluid>div>h2
	text-large-hero-component      css       .container-fluid.small.center-block.row-fluid>div>h3
    view-more-insight              css       .cta.white.wpg-slider-cta
	Featured-auther-section        css       .module-header-two-columns-extra-slider
    featured-author-heading        css       .col-xs-12>h2
    auther-detail-box              css       .col-xs-12.col-md-6.wpg-extra-content-wrap
    auther-image                   css        .wpg-person>img
    auther-name                    css        .wpg-person>h3
    auther-degination              css        .wpg-person>p
    author-discription-read-more   css        .col-xs-12.col-md-6.wpg-extra-content-wrap>p>a
    exprince-*                         css         .wpg-table-person>thead>tr>th
	exprinceNumber-*                  css         .wpg-table-person>tbody>tr>td
    author-slides                      css          .col-xs-12.col-md-6.wpg-extra-slide-wrap
    left-arrow                         xpath          //a[@class="wpg-extra-slide-prev"]/i[@class="zmdi zmdi-arrow-left"]
    right-arrow                         xpath          //a[@class="wpg-extra-slide-next"]/i[@class="zmdi zmdi-arrow-right"]
    slide-image                         css            .wpg-images-extra-slide
    author-slides-text                  css         .wpg-nanette
    author-slides-heading               css         .wpg-main-box-extra-slide>h3>a
    author-slides-date                  css       .wpg-foot-extra-slide>p
	insight-section                     css       .wrapper.insights
	insight-section-header              css       .section-header
	blue-divider                        xpath      html/body/div[2]/div[4]/div[1]
	global-expertile-container          css       .container.sort-buttons
	insight-category-*                  xpath       //div[@class="button-wrapper"]
	insight-slide-cantainer             css       .owl-carousel.owl-theme
	insight-left-arrow                  css       .zmdi.zmdi-arrow-left.zmdi-hc-2x
	insight-right-arrow                 css       .zmdi.zmdi-arrow-right.zmdi-hc-2x
	insight-slides-*                    xpath       //div[@class="owl-item"]
	read-more                          xpath       //a[contains(text(),'Read more insights')]
	

	
	
=Hero component=
    @on *
	    large-hero-component:
		   above Featured-auther-section ~80px
		   below header 0px
		   width ~ 100% of screen/width
		   height 27% of screen/width
	
	    
		   
		heading-large-hero-component:
           centered horizontally inside large-hero-component
		   above text-large-hero-component 10 to 20 px
           text is "Shared insights take us further"
		   css font-size is "50px"
		   css font-family starts "Mercury-DisplayRoman"
		   
		text-large-hero-component:
		    centered horizontally inside large-hero-component
            text contains "We believe that our culture of sharing and debating ideas across all of our"
			css font-size is "21px"
		    css font-family starts "Mercury-DisplayRoman"
		
=Author section=
    @on *    		
		Featured-auther-section:
            below large-hero-component 80px
            above insight-section 0px
			width 100% of screen/width
          		   
	    featured-author-heading:
		    centered horizontally inside Featured-auther-section
			above auther-detail-box
            text is "FEATURED AUTHOR"
			css font-size is "25px"
		    css font-family starts "BentonSans-Black"
		auther-detail-box:
            inside Featured-auther-section
            width ~ 483px
			height ~ 487px
			left-of left-arrow
			
        auther-image:
            inside auther-detail-box 0px top
            width ~ 190px
            height ~ 190px
			above auther-name
		auther-name:
		   inside auther-detail-box
           above auther-degination
           below auther-image
           css font-size is "21px"
		   css font-family starts "BentonSans-Bold"		   
		auther-degination:
		   inside auther-detail-box
           above author-discription-read-more
           below auther-name
           css font-size is "16px"
		   css font-family starts "Mercury-DisplayItalic"
		author-discription-read-more:
		   inside auther-detail-box
           above exprince-1
           below auther-degination
           css font-size is "14px"
		   css font-family starts "BentonSans-Bold"
		exprince-*:
           below author-discription-read-more
		   inside auther-detail-box 35px bottom
           css font-size is "14px"
		   css font-family starts "Mercury-DisplayItalic"
		@forEach [exprince-*] as Exprince, prev as previousExprince
            ${Exprince}:
                right-of ${previousExprince} 0 to 1px
                aligned horizontally all ${previousExprince}
        exprinceNumber-*:
           below author-discription-read-more
		   inside auther-detail-box 0px bottom
           css font-size is "25px"
		   css font-family starts "BentonSans-Book"
		@forEach [exprinceNumber-*] as exprincenumber, prev as previousexprincenumber
            ${exprincenumber}:
                right-of ${previousexprincenumber} 0 to 1px
                aligned horizontally all ${previousexprincenumber}				
		author-slides:
            right-of auther-detail-box 
            
		slide-image:
            inside author-slides
            width 64% of 	author-slides/width
            above author-slides-text 7px
			
		author-slides-text:
           below slide-image 7px
		   inside author-slides
           above author-slides-heading 10px
           css font-size is "12px"
		   css font-family starts "BentonSans-Book"		   
		author-slides-heading:
           below author-slides-text 10px
		   inside author-slides
           above author-slides-date	54px
		   css font-size is "16px"
		   css font-family starts "BentonSans-Black"
		author-slides-date:
           inside author-slides 51px bottom
           below author-slides-heading
		   css font-size is "12px"
		   css font-family starts "Mercury-DisplayItalic"
=Insight Section=
	@on *	   
		insight-section:
           below Featured-auther-section 0px
		   width 100% of screen/width
		   
		insight-section-header:
		   centered horizontally inside insight-section 100px top
		   above blue-divider 12px
		   css font-size is "25px"
		   css font-family starts "BentonSans-Black"
		   text is "GLOBAL EXPERTISE"
		global-expertile-container:
           below blue-divider 0px
		   above insight-left-arrow 5px
		   above insight-right-arrow 5px
		   
		insight-category-*:
           inside global-expertile-container
            height 42px
			
           		   
		   
		read-more:
		    centered horizontally inside screen 
			text is "READ MORE INSIGHTS"
			css font-size is "14px"
		    css font-family starts "BentonSans-Bold"
           		
		@forEach [insight-category-*] as insightcategory, prev as previousinsightcategory
            ${insightcategory}:
                right-of ${previousinsightcategory} 0 to 1px
                aligned horizontally all ${previousinsightcategory}
		insight-slide-cantainer:
            below global-expertile-container 55px
            above read-more 50px

		insight-left-arrow:
            above insight-slide-cantainer ~ 5px top	
		insight-right-arrow:
            above insight-slide-cantainer ~ 5px top	
		insight-slides-*: 
            below insight-right-arrow 36px	
            below insight-left-arrow 36px
            width 337px
            height 403px
			