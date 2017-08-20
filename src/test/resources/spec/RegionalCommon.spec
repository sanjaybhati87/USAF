
@objects
    top-of-header            css   #top-header
	company-name             css   .company-name
    change-country           xpath   //*[@id='top-header']/div/div[1]/ul/li[3]/a
	selected-country         css     .language
    website-link             css    .website
    login-link               css    .login
    header                   css   .container.nav-container
    header-logo              css   .logo-link>img
    cookies-policy           css   .cookies-policy
	menu                     xpath  html/body/div[2]/header/div[1]
    menu-item-*              xpath  //*[@id='main-nav']/ul[1]/li
    search                   xpath  //div[@id='search-box']/i	
    top-of-footer            css    .container.footer-top
	top-of-footer-item-*     css    .footer-nav>ul>li>a
	devider                  xpath  //footer/div[2]/div
    footer                   css   .footer-nav
	footer-item-*            css   .footer-nav>ul>li>a
    below-footer             xpath //footer/div[4]/div/h5
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
            width ~ 1350px
			 
			 
	    header:
            below top-of-header 0 to 1px
            centered horizontally inside screen 1px
            height ~ 76px
            
        header-logo:
            inside header 2 to 5px top, 10 to 15px left
			height ~ 45px
			width ~ 178px
            

        cookies-policy:
            below header 0px
            
               
        change-country:
           inside top-of-header ~ 600px left 
           inside top-of-header ~ 10px top
           right-of company-name ~ 225px 
		   width ~ 48px
		   height ~ 15px
		   text is "Change"
		   
        company-name:    
           inside top-of-header ~ 190px left 
           inside top-of-header ~ 0px top
           left-of selected-country 3 to 5px
		   width ~ 182px
		   height ~ 29px
		   text is "Wellington Management Funds"
		   
		website-link:   
		   inside top-of-header ~ 955px left 
           inside top-of-header ~ 10px top
           left-of login-link 50 to 55px 
		   width ~ 90px
		   height ~ 15px
		   text is "Wellington.com"
		   
		login-link:   
		   inside top-of-header ~ 1098px left 
           inside top-of-header ~ 10px top
           right-of website-link 45 to 50px 
		   width ~ 36px
		   height ~ 15px
		   text is "Login"   
		   
    @on desktop
        header:
            width ~ 986px

        


    @on mobile, tablet
        header:
            width ~ 986px




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
        search:
          right-of 	menu-item-5 ~15px
          width 73px
          height 30px		  
		   
    @on desktop
        menu:
            width ~ 1349px
			height ~ 75px


    @on desktop, tablet
        menu-item-*:
            height ~ 72px
            inside header ~ 0px top

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

        @for [ 1, 2 ] as index
            menu-item-${index}:
                above menu-item-${index + 2} 0 to 5px

        @for [ 1, 3 ] as index
            menu-item-${index}:
                near menu-item-${index + 1}  0 to 5 px left





= Footer =
    foot-note:
	    height ~ 125px
		width ~ 965px
    disclosure-heading:
        inside 	foot-note 11px left,right, 0px top, 95px bottom
		text is "DISCLOSURES & FOOTNOTES"
		
	
         
		
    top-of-footer:
	    below foot-note ~ 65px 
		above devider ~ 12px
		width 988px
		height ~ 165px
		text is "We seek to exceed investment objectives and service expectations of our clients and advisers globally."
	footer:
	    below devider ~ 0px
		below top-of-footer ~ 30px
		height ~ 130px
		width ~ 966px
	footer-item-1:
            text is "Disclosures"
    footer-item-2:
            text is "Privacy Policy"
    footer-item-3:
            text is "Terms of Use"
    footer-item-4:
            text is "Cookie Policy"	