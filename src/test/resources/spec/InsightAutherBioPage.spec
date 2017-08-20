@import Regionalcommon.spec

@objects
    large-hero-component           xpath      //div[@class="wrapper wpg-author-single wpg-js-bg-paralaxy"]/div[@class="container"]
	author-image-section           css         .left.image.col-md-12.col-lg-4.col-sm-12.col-xs-12
	author-image                   xpath        //div[@class="avatar-wrapper"]/img
	author-exprince-*              css          .left.image.col-md-12.col-lg-4.col-sm-12.col-xs-12>table>tbody>tr>td
	author-description-section     css         .left.person-info.col-md-12.col-lg-8.col-sm-12.col-xs-12
	author-name                    xpath       //div[contains(@class,'left person-info col-md-12')]/h2
	author-degination              css          .desc
	author-description-text        xpath        //div[contains(@class,'left person-info col-md-12')]/p[2]
	all-insight-heading            xpath        //h2[text()="All insights"]
	all-insights-slide-*            xpath        //div[@class="padding wpg-columns-3"]
	read-more                       xpath       //a[contains(text(),'LOAD More Insight')]
	
	

	
	
=Auther bio section=
    @on *
	    large-hero-component:
		   below header 0px
		   width 100% of screen/width
		   height 33% of screen/width
	
	    
		   
		author-image-section:
           inside large-hero-component ~ 80px top
		   left-of author-description-section 0px
		author-image:
           inside author-image-section 14px top
           width 180px
		   height 180px
        author-exprince-1:
           text is "Industry experience"
		   left-of author-exprince-2 0px
		   css font-size is "14px"
		   css font-family starts "Mercury-DisplayItalic"
		   aligned horizontally all author-exprince-2
		   
		author-exprince-2:
           text is "With Wellington"
		   right-of author-exprince-1 0px
		   css font-size is "14px"
		   css font-family starts "Mercury-DisplayItalic"
		   aligned horizontally all author-exprince-1 
		   
        author-exprince-3:
		   left-of author-exprince-4 0px
		   css font-size is "25px"
		   css font-family starts "BentonSans-Book"
		   aligned horizontally all author-exprince-4
		   aligned vertically all author-exprince-1
		 
		author-exprince-4:
		   right-of author-exprince-3 0px
		   css font-size is "25px"
		   css font-family starts "BentonSans-Book"
		   aligned horizontally all author-exprince-3 
		   aligned vertically all author-exprince-2
		   
		author-description-section:
		    right-of author-image-section
			inside large-hero-component
			
		author-name:
		   inside author-description-section 21px top
		   css font-size is "21px"
		   css font-family starts "BentonSans-Black"
		   above author-degination ~ 5px
		   
		author-degination:
		   inside author-description-section 
		   css font-size is "16px"
		   css font-family starts "Mercury-DisplayItalic"
		   below author-name ~ 5px
		   
		author-description-text:
		   inside author-description-section 
		   css font-size is "14px"
		   css font-family starts "BentonSans-Book"
		   below   author-degination ~ 20px  
		   
=Insight section=
	@on *	   
		all-insight-heading:
           centered horizontally inside screen 
		   width 71% of screen/width
		   below large-hero-component
		   text is "ALL INSIGHTS"
		   css font-size is "25px"
		   css font-family starts "BentonSans-Black"
		   
		all-insights-slide-*:
		   height ~ 420px
		   
			
           		   
		   
		read-more:
		    centered horizontally inside screen 
			text is "LOAD MORE INSIGHTS"
			css font-size is "14px"
		    css font-family starts "BentonSans-Bold"
           		
		