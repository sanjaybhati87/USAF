@import Globalcommon.spec
@objects
    large-hero-component                 css  .module-bg-header.module-bg-header-contact.wpg-js-bg-paralaxy
	text-area-inside-hero-component      css   .span-table-cell.vertical-align-middle
	text-heading                         css   .wpg-mbhc-top>h1
	text-paragraph                       css   .wpg-mbhc-top>p
	email-box                            css   .wpg-mbhc-bottom>p
	emails-*                             css    .wpg-mbhc-bottom>p>a
	email-icons-*                        css    .zmdi.zmdi-email
	local-contact                        xpath    //a[text()="Local Contact"]
	submit-request                       xpath   //a[text()="Submit a request"]
	office-location-container            css    .span-table.wpg-three-boxes-table
	office-locations-*                   css     .span-table-cell.vertical-align-top
	heading-inside-contacts_*            css      .span-table-cell.vertical-align-top>h4
	text-inside-contacts_*                xpath     //div[@class="span-table-cell vertical-align-top"]/p[1]
    phone-inside-contacts_*               xpath     //div[@class="span-table-cell vertical-align-top"]/p[2]
    icon-section                          css         .module-large-icons
	icon-items-*                          css         .col-xs-6
	text-inside-icon-items-*              css         .col-xs-6>a>strong
	image-inside-icon-items-*             css          .col-xs-6>a>span>img
	
	
=Large Hero component=
    @on *
	    large-hero-component:
	       below header 0px
	       above local-contact ~ 85px
		   width 100 % of screen/width 
		   height ~ 386px
	   
	
	    text-area-inside-hero-component:
		    centered horizontally inside large-hero-component
		    width ~ 965px
		    height ~ 215px
        text-heading:
           centered horizontally inside text-area-inside-hero-component 0px top
           css font-size is "50px"
		   css font-family starts "Mercury-DisplayRoman"
		   
 		
		email-box:
            centered horizontally inside text-area-inside-hero-component 0px bottom
            width 100% of text-area-inside-hero-component/width	
			height 26px
			below text-paragraph ~ 25px
		emails-1:
            left-of emails-2
			inside email-box
            text is "info@wellington.com"
			css font-size is "17px"
		    css font-family starts "Mercury-DisplayRoman"
		emails-2:
            right-of email-icons-1
			inside email-box 
            text is "Wellington@icareerhelp.com"
			css font-size is "17px"
		    css font-family starts "Mercury-DisplayRoman"
=Contact box=			
			
        local-contact:
              below large-hero-component
              above office-location-container
			  left-of submit-request 0px
			  aligned horizontally all submit-request
              text is "LOCAL CONTACT"
              css font-size is "14px"
		      css font-family starts "BentonSans-Bold"
        submit-request:
              below large-hero-component
              above office-location-container
			  right-of local-contact 0px
			  aligned horizontally all local-contact
              text is "SUBMIT A REQUEST"
              css font-size is "14px"
		      css font-family starts "BentonSans-Bold"
=Office Locations=			  
		office-location-container:
               below submit-request
               above icon-section			   
        office-locations-*:
		      inside office-location-container
              width 300px
              height 209px
        @forEach [office-locations-*] as officeLocation, prev as previousofficeLocation
            ${officeLocation}:
                right-of ${previousofficeLocation} 20 to 25px
                aligned horizontally all ${previousofficeLocation}
        heading-inside-contacts_*:
                css font-size is "17px"
		        css font-family starts "Mercury-DisplayBold"
                width 254px
                height 37px
		@forEach [heading-inside-contacts_*] as officeLocationheading, prev as previousofficeLocationheading
            ${officeLocationheading}:
                right-of ${previousofficeLocationheading} 60 to 70px
                aligned horizontally all ${previousofficeLocationheading}
        text-inside-contacts_*:	
                css font-size is "12px"
		        css font-family starts "BentonSans-Book"
                width 254px
               
        @forEach [text-inside-contacts_*] as officeLocationtext, prev as previousofficeLocationtext
            ${officeLocationtext}:
                right-of ${previousofficeLocationtext} 60 to 70px
                aligned horizontally top ${previousofficeLocationtext}
=Office Location icon section=				
        icon-section:
            below office-location-container
            above  footer
		icon-items-*:
            width ~ 369px
            height ~ 160px
		@forEach [icon-items-*] as iconItem, prev as previousiconItem
            ${iconItem}:
                right-of ${previousiconItem} 0 to 1px
                aligned horizontally all ${previousiconItem}
        text-inside-icon-items-1:
               text is "Email Us"
               css font-size is "16px"
		       css font-family starts "BentonSans-Bold"
			   aligned horizontally all text-inside-icon-items-2
		text-inside-icon-items-2:
               text is "All Office Locations"
               css font-size is "16px"
		       css font-family starts "BentonSans-Bold"
			   aligned horizontally all text-inside-icon-items-1	   