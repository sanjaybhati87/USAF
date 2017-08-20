@import Regionalcommon.spec

@objects

		HeaderImage						css					.wl-fundslider
		HeaderInnerBox-*				css					.wl-fundslider__item
		FocusFundSmallImage-*			xpath				//div[@class="js-fundslider"]/section[2]/div/div/span
		FocusFundBoxTitle-*				css					.wl-incomeblock__title		
		FocusFundBoxText-*				css					.wl-incomeblock__summary
		ShareClassText-*				css					.wl-incomeblock__shareclass>label
		ShareClassSelectBox-*			css					#select2-share-class-label-1-container
		InformationBox-*				css					.wl-incomeblock__col
		FilterFundBackground			css					.wl-fundfilter
		FilterText						css					.wl-fundfilter__title
		FilterTextBox					css					#fundfilter-search
		SearchButton					css					.wl-fundfilter__search>button
		AssetClassTextBox				css					#select2-asset-class-container
		TypeTextBox						css					#select2-search-type-container
		DomiciletextBox					css					#select2-search-domicile-container
		TextBoxText-*					css					.select2-selection__placeholder
		ResultText						css					.wl-fundlist__results
		AtGlanceBox-*					css					.wl-fundlist__nav>a
		ViewAllFundText					css					.wl-fundlist__viewall
		leftInformationBox-*			css					.wl-complexfund__info.js-complexFundInfo
		SmallImage-*					css					.wl-complexfund__initials.wl-complexfund__initials
		FundInformation-*				css					.wl-complexfund__date
		FundTitle-*						css					.wl-complexfund__title
		FundSizeBox-*					css					.wl-complexfund__label
		TextValue-*						css					.wl-complexfund__details>span
		NumericValue-*					css					.wl-complexfund__details>h3
		DocumentsImage-*				css					.wl-complexfund__docs>a
		AuthorImage-*					css					.wp-complexfund__teamavatar
		AuthorName-*					css					.wp-complexfund__teamname
		
		
		
=Header=
	 
		HeaderImage:
			height 541px
		
		HeaderInnerBox-1:
			height 421px
			inside partly HeaderImage 65px top
		
		FocusFundSmallImage-1:
			height 35px
			width 35px
			
		FocusFundBoxTitle-2:
			height 70px
			css font-size is "34px"
			
		FocusFundBoxText-2:
			below HeaderImage -405px
			css font-size is "14px"
			css font-family contains "BentonSans-Regular"
			
		ShareClassText-2:
			below FocusFundBoxText-2 ~ 72px
			css font-size is "14px"
			css font-family contains "Mercury-DisplayItalic"
			
		ShareClassSelectBox-2:
			height 53px
			width 514px
			below ShareClassText-2 8px
			css font-size is "34px"
			css font-family contains "BentonSans-Regular"
			
		@for [6,7,8,9,10] as index
			InformationBox-${index}:
			
				height 134px
				width 160px
				below ShareClassSelectBox-2 ~ 26px
		
		FilterFundBackground:
				height 291px
				width 1349px
				below HeaderImage 19px
		
		FilterText:
		
				below HeaderImage 50px
				css font-size is "21px"
				css font-family contains "Mercury-DisplayRoman"
				
				
		FilterTextBox:
				height 45px
				width 960px
				below FilterFundBackground -221px
				aligned vertically left FilterText  
		
		SearchButton:
				height 47px
				width 32px
				below FilterFundBackground -221px
				left-of FilterTextBox -938px
				
				
		AssetClassTextBox:
				height 43px
				width 225px
				below FilterFundBackground -146px
				aligned vertically left FilterText  
				
				
		TypeTextBox:
				height 43px
				width 225px
				below FilterFundBackground -146px
				aligned horizontally top AssetClassTextBox  
				
				
		DomiciletextBox:
				height 43px
				width 225px
				below FilterFundBackground -146px
				aligned horizontally top AssetClassTextBox  
				
		TextBoxText-*:
			height 17px
			css font-size is "14px"
			css font-family contains "BentonSans-Bold"
			below AssetClassTextBox -27px
			
		ResultText:
			css font-size is "16px"
			css font-family contains "BentonSans-Regular"
			below AssetClassTextBox 183px
			aligned vertically left FilterText  
			
			
		AtGlanceBox-*:
			height 48px
			width 146px
			css font-size is "14px"
			css font-family contains "BentonSans-Medium"
			below ResultText 16px
			
		ViewAllFundText:
			css font-size is "14px"
			css font-family contains "BentonSans-Bold"
			aligned horizontally top AtGlanceBox-1
			
			
		leftInformationBox-*:
		
				height 400px
				width 240px
				aligned vertically left AtGlanceBox-1 1px
				
		SmallImage-*:
				height 35px
				width 35px
				
		FundInformation-*:
			css font-size is "14px"
			css font-family contains "Mercury-DisplayItalic"
			
		FundTitle-*:
			
			width  239px
			css font-size is "25px"
			css font-family contains "BentonSans-Bold"
			
		@for [1-15,17-22] as index
			FundSizeBox-${index}:
			
				css font-size is "14px"
				css font-family contains "Mercury-DisplayItalic"
				
		TextValue-*:
				css font-size is "14px"
				css font-family contains "BentonSans-Medium"
				
		NumericValue-*:
				css font-size is "25px"
				css font-family contains "BentonSans-Regular"
				
		DocumentsImage-*:
				height 51px
				width 90px
				
		
			
		@for [2,7,12] as index
			AuthorImage-${index}:
				height 101px
				width 101px
				
			AuthorName-${index}:
				css font-size is "16px"
				css font-family contains "BentonSans-Bold"
				below AuthorImage-${index} 0px
			
		
			
			
				
			
			
		
		