

@objects
    Large-hero-component                       css     .container-fluid.small.center-block.row-fluid>div
    client-driven-investment                   css    .container-fluid.small.center-block.row-fluid>div>h2
    text-below-client-driven-investment        css   .container-fluid.small.center-block.row-fluid>div>h3
    select-country                             xpath   //a[contains(text(),'Select a Country')]
	text-component                             css     .col-xs-12
    why-wellington-managment                   xpath  //h2[text()='Why Wellington Management Funds']
	text-below-why-wellington-managment        css    .col-xs-12>p
	strength-section                           xpath    //div[@class="wrapper four-tiles-bg"]/div[@class="container"]
	our-desctive-strength                      xpath   //h2[contains (text(), 'Our distinctive strengths')]
	stength-item-*                             css    .wpg-tile
	investemnt-capability-section              xpath   //div[@class="wrapper capabilities"]
	investment-capability                      xpath   //h2[text()='Fund offerings']
	text-inside-investment-capability          css     .wrapper.container>p
	capability-item-*                          css     .capability-item
	image-inside-capability-item-*             xpath    //div[@class="capability-item"]//div[@class="wpg-ico-container"]
	heading-inside-capability-item-*           css     .capability-item>h3
	description-inside-capability-item-*       css     .capability-item>p
	explore-more                               xpath   //a[contains(text(), 'Explore capabilites ')]
	speaker-section                            css     .module-circle-quotation
	speaker-image                              css      .col-xs-12.col-sm-6.wpg-image-box>img
	speaker-text                               css       .col-xs-12.col-sm-6.wpg-quotation-box
	header                                     css   .container.nav-container
    header-logo                                css   .logo-link>img
    cookies-policy                             css   .cookies-policy
	menu                                       xpath  //div[@class="animated-wrapper"]/header
    menu-item-*                                xpath  //*[@id='main-nav']/ul[1]/li 
    top-of-footer                              css    .container.footer-top
	top-of-footer-item-*                       css    .footer-nav>ul>li>a
	devider                                    xpath  //footer/div[2]/div
    footer                                     css   .footer-nav
	footer-item-*                              css   .footer-nav>ul>li>a
    below-footer                               xpath //footer/div[4]/div/h5
    cookies-text                               css   .container>h5
    tagline                                    css   .container.footer-top>h2
    company-name                               css   .company-name
    top-of-header                              css   #top-header
    select-country-header                      xpath   //*[@id='top-header']/div/div[1]/ul/li[3]/a
    website-link                               css    .website
    login-link                                 css    .login
	
	
    
    
= Hero component =
    @on *
	    Large-hero-component:
		  below header 0px
		  
	     
        client-driven-investment:
            centered horizontally inside Large-hero-component 100px top
            text is "A global view and an eye for detail"
            css font-size is "50px"
			css font-family contains "Mercury-DisplayRoman"			

        text-below-client-driven-investment:
			css font-size is "21px"
			css font-family contains "Mercury-DisplayRoman"

        select-country:
            below text-below-client-driven-investment ~ 74px
			centered horizontally inside Large-hero-component 1px
			
= Text component =
    @on *
	    text-component:
		   below Large-hero-component
		   
        why-wellington-managment:
		    inside text-component 0px top
			centered horizontally inside text-component
			css font-size is "25px"
		    css font-family starts "BentonSans-Black"
			text is "WHY WELLINGTON MANAGEMENT FUNDS"
            
            
        text-below-why-wellington-managment:
		   below why-wellington-managment ~ 25px
		   css font-size is "14px"
		   css font-family starts "BentonSans-Book"
		   
= Our Strengths =
    @on *

        strength-section:
            below investemnt-capability-section 
            	
			
      
		   
		stength-item-*:
		  inside strength-section 
          width ~ 472px
		  height ~ 210px
		@for [ 1, 2 ] as index
            stength-item-${index}:
                above stength-item-${index + 2} 0 to 1px
		@for [ 1, 3 ] as index
            stength-item-${index}:
                aligned horizontally all stength-item-${index + 1}
		
= Investment Capability =
    @on *
	    investemnt-capability-section:
		    above strength-section 
			
			 
        investment-capability:
		   width ~ 965px
		   height ~ 72px
		   centered horizontally inside investemnt-capability-section, 100px top
		   text is "Fund offerings"
		   css font-size is "50px"
		   css font-family starts "Mercury-DisplayRoman"
		 
		
		capability-item-*:
		    width ~ 241px
			height ~ 302 px
			inside investemnt-capability-section
			
		
		@forEach [capability-item-*] as capabilityItem, prev as previouscapabilityItem
            ${capabilityItem}:
                right-of ${previouscapabilityItem} 0 to 5px
                aligned horizontally all ${previouscapabilityItem}
		image-inside-capability-item-*:
                width 104 px
                height 104px
				
		@forEach [image-inside-capability-item-*] as imageItem, prev as previousimageItem
            ${imageItem}:
                right-of ${previousimageItem} 135 to 140px
                aligned horizontally all ${previousimageItem}
		heading-inside-capability-item-*:
		    css font-size is "21px"
            css font-family matches	 "BentonSans-Bold"
            
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
           inside top-of-header ~ 390px left 
           inside top-of-header ~ 10px top
           right-of company-name 5 to 10px 
		   width ~ 100px
		   height ~ 15px
		   text is "Select country"
		   css font-size is "11px" 
		   css font-family matches "BentonSans-Bold"
		   
        company-name:    
           inside top-of-header ~ 190px left 
           inside top-of-header ~ 0px top
           left-of select-country-header 4 to 6px
		   width ~ 190px
		   height ~ 29px
		   text is "Wellington Management FUNDS"
		   css font-size is "12px" 
		   css font-family matches "BentonSans-Book"
		   
		website-link:   
		   inside top-of-header ~ 958px left 
           inside top-of-header ~ 10px top 
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
		   
    @on desktop
        menu:
            width ~ 1349px
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
            text is "Cookie Policy"	            
= 