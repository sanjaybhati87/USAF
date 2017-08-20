
@objects
    header                   css   .container.nav-container
    header-logo              css   .logo-link>img
    cookies-policy           css   .cookies-policy
	menu                     xpath  //div[@class="animated-wrapper"]/header
    menu-item-*              xpath  //*[@id='main-nav']/ul[1]/li 
    top-of-footer            css    .container.footer-top
	top-of-footer-item-*     css    .footer-nav>ul>li>a
	devider                  xpath  //footer/div[2]/div
    footer                   css   .footer-nav
	footer-item-*            css   .footer-nav>ul>li>a
    below-footer             xpath //footer/div[4]/div/h5
    cookies-text             css   .container>h5
    tagline                  css   .container.footer-top>h2
    company-name             css   .company-name
    top-of-header            css   #top-header
    select-country-header    xpath   //*[@id='top-header']/div/div[1]/ul/li[3]/a
    website-link             css    .website
    login-link               css    .login
    foot-note                xpath   //div[@class="module-df"]//div[contains(@class,'col-xs-12 wpg-check-more-box-js')]
    disclosure-heading       css   .col-xs-12.wpg-check-more-box-js>h2
    disclosure-text1         xpath  .col-xs-12.wpg-check-more-box-js>p
	disclosure-text2         xpath  .col-xs-12.wpg-check-more-box-js>p
    cookies-text             css   .container>h5
    tagline                  css   .container.footer-top>h2


= Header =
    @on *
        top-of-header:
            inside screen 0px top
            height ~ 30px
            
			 
			 
	    header:
            below top-of-header 12 to 15px
            centered horizontally inside screen 1px
            height ~ 76px
            
        header-logo:
            inside header 4 to 5px top, 10 to 12px left
			height ~ 45px
			width ~ 178px
			
            

        cookies-policy:
            below header -4px
			text is "We use cookies to improve your experience on our website. By continuing you are giving consent to cookies being used. LEARN MORE"
			css font-size is "14px" 
			css font-family matches "BentonSans-Book"
            
               
        select-country-header:
           inside top-of-header ~ 603px left 
           inside top-of-header ~ 10px top
           right-of company-name 220 to 230px 
		   width ~ 47px
		   height ~ 15px
		   text is "Change"
		   css font-size is "11px" 
		   css font-family matches "BentonSans-Bold"
		   
        company-name:    
           inside top-of-header ~ 192px left 
           inside top-of-header ~ 0px top
           left-of select-country-header 220 to 226px
		   width ~ 190px
		   height ~ 29px
		   text is "Wellington Management FUNDS"
		   css font-size is "12px" 
		   css font-family matches "BentonSans-Book"
		   
		website-link:   
		   inside top-of-header ~ 956px left 
           inside top-of-header ~ 10px top
           left-of login-link 50 to 55px 
		   width ~ 90px
		   height ~ 15px
		   text is "Wellington.com"
		   css font-size is "11px" 
		   css font-family matches "BentonSans-Bold"
		   
		login-link:   
		   inside top-of-header ~ 1098px left 
           inside top-of-header ~ 10px top
           right-of website-link 45 to 50px 
		   width ~ 36px
		   height ~ 15px
		   text is "Login"
           css font-size is "11px" 
		   css font-family matches "BentonSans-Bold"		   
		   
    @on desktop
        header:
            width ~ 986px

        


    @on mobile, tablet
        header:
            width ~ 1349px




= Menu =
    @on *
        menu:
           centered horizontally inside screen 1px
           below top-of-header ~ 4px
		    
		   
		menu-item-1:
           text is "FUNDS"		
        menu-item-2:
           text is "CAPABILITIES"

		menu-item-3:
           text is "LITERATURE" 
        menu-item-4:
           text is "INSIGHTS"
        menu-item-5:
           text is "CONTACT"        
		   
    @on desktop
        menu:
            width ~ 1264px
			height ~ 80px


    @on desktop, tablet
        menu-item-*:
            height ~ 72px
			css font-size is "14px" 
		    css font-family matches "BentonSans-Book"

        @forEach [menu-item-*] as menuItem, prev as previousMenuItem
            ${menuItem}:
                right-of ${previousMenuItem} 0 to 5px
                aligned horizontally all ${previousMenuItem}
				
        footer-item-*:
            height ~16px
			inside footer 26px top
		@forEach [footer-item-*] as footerItem, prev as previousFooterItem
            ${footerItem}:
                right-of ${previousFooterItem} 0 to 5px
                aligned horizontally all ${previousFooterItem}
				
        				

    @on mobile
        menu-item-* :
            width 48 to 50% of screen/width
			css font-size is "11px" 
		    css font-family matches "BentonSans-Bold"
			

        @for [ 1, 2 ] as index
            menu-item-${index}:
                above menu-item-${index + 2} 0 to 5px

        @for [ 1, 3 ] as index
            menu-item-${index}:
                near menu-item-${index + 1}  0 to 5 px left





= Footer =
 		
	foot-note:
	    height ~ 145px
		width ~ 965px
    disclosure-heading:
        inside 	foot-note 11px left,right, 0px top, 116px bottom
		text is "DISCLOSURES & FOOTNOTES"
			
    top-of-footer:
		above devider ~ 12px
		width 988px
		height ~ 165px
		text is "We seek to exceed the investment objectives and service expectations of our fund investors and their advisers worldwide."
	footer:
	    below devider ~ 0px
		below top-of-footer ~ 30px
		height ~ 130px
		width ~ 966px
	footer-item-*:
        height ~ 17px
        inside footer ~ 25px top
	    css font-size is "14px" 
		css font-family matches "BentonSans-Book"	
    footer-item-1:
            text is "Privacy Policy"
    footer-item-2:
            text is "Terms of Use"
    footer-item-3:
            text is "Cookie Policy"	