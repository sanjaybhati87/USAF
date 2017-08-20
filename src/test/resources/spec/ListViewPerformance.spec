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
		FundsHeader-*					css					.sorting
		FundNameBox-*					css					.highlighted.odd>td
		EvenFundDetailbox-*				css					.even>td
		ISIN-*							css					.wl-table__title__top
		FundName-*						css					.wl-table__title__bottom
		TickMark-*						css					.zmdi.zmdi-check-circle
		
		
		
		
		
		
		
=Header=

	@on desktop
	 
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
					below FocusFundBoxText-2 72px
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
						below ShareClassSelectBox-2 26px
				
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
					
				
				
				
				
				
				
		
						
				@for [1,2,3,6,7] as index
					FundsHeader-${index}:
						aligned horizontally top FundsHeader-${index+1}
						
						
				FundNameBox-1:
						height 59px
						width 317px
						css font-size is "12px"
						css font-family contains "BentonSans-Bold"
						
				
					
						
				EvenFundDetailbox-1:
							height 59px
							width 317px
							css font-size is "12px"
							css font-family contains "BentonSans-Bold"
						
					
				@for [3-7] as index
						EvenFundDetailbox-${index}:
							height 59px
							width 55px
							css font-size is "12px"
							css font-family contains "BentonSans-Bold"
							aligned horizontally top EvenFundDetailbox-1
							
							
				ISIN-*:
							height 14px
							width 116px
							css font-size is "11px"
							css font-family contains "BentonSans-Bold"
						
							
			
							
				TickMark-*:
							height 36px
							width 30px
	
	
	@on mobile
	
				HeaderImage:
					height 456px
					width 99% of screen/width 
					
				HeaderInnerBox-1:
					height 426px
					width 99% of screen/width 
					inside partly HeaderImage 15px top
					
				FocusFundSmallImage-1:
					height 35px
					width 35px
					
				FocusFundBoxTitle-2:
					height 73px
					width 88% of screen/width					
					css font-size is "21px"
					
				FocusFundBoxText-2:
					below HeaderImage -342px
					css font-size is "12px"
					css font-family contains "BentonSans-Regular"
					
				ShareClassText-2:
					below FocusFundBoxText-2 70px
					css font-size is "12px"
					css font-family contains "Mercury-DisplayItalic"
					
				ShareClassSelectBox-2:
					height 48px
					width 78% of screen/width	
					below ShareClassText-2 8px
					css font-size is "25px"
					css font-family contains "BentonSans-Regular"
					
				@for [7,8,9] as index
					InformationBox-${index}:
					
						height 139px
						width 29% of screen/width
						below ShareClassSelectBox-2 -13px
						
				FilterFundBackground:
						height 420px
						width 99% of screen/width
						below HeaderImage 0px
						
				FilterText:
				
						below HeaderImage 31px
						css font-size is "21px"
						css font-family contains "Mercury-DisplayRoman"
						
						
				FilterTextBox:
						height 45px
						width 89% of screen/width
						below FilterFundBackground -345px
						
						
				SearchButton:
						height 47px
						width 32px
						below FilterFundBackground -345px
						left-of FilterTextBox -305px
						
						
				AssetClassTextBox:
						height 43px
						width 89% of screen/width
						below FilterFundBackground -265px
						aligned vertically left FilterTextBox  
						
						
				TypeTextBox:
						height 43px
						width 89% of screen/width
						below FilterFundBackground -202px
						aligned vertically left AssetClassTextBox 
						
				DomiciletextBox:
						height 43px
						width 89% of screen/width
						below FilterFundBackground -139px
						aligned vertically left TypeTextBox 
						
						
						
				TextBoxText-*:
					height 17px
					css font-size is "14px"
					css font-family contains "BentonSans-Bold"
					
					
				ResultText:
					css font-size is "16px"
					css font-family contains "BentonSans-Regular"
					below AssetClassTextBox 272px
					aligned vertically left FilterText  
					
					
				AtGlanceBox-*:
					height 37px
					width 28% of screen/width
					css font-size is "11px"
					css font-family contains "BentonSans-Medium"
					below ResultText 21px
					
					
					
					
	@on tab
	
			    HeaderImage:
					height 69% of screen/width 
					width 100% of screen/width 
					
				HeaderInnerBox-1:
					height 54% of screen/width
					width 100% of screen/width 
					inside partly HeaderImage 65px top
					
				FocusFundSmallImage-1:
					height 35px
					width 35px
					
				FocusFundBoxTitle-2:
					height 9% of screen/width
					width 98% of screen/width					
					css font-size is "34px"
					
				FocusFundBoxText-2:
					below HeaderImage -400px
					css font-size is "14px"
					css font-family contains "BentonSans-Regular"
					
				ShareClassText-2:
					below FocusFundBoxText-2 70px
					css font-size is "14px"
					css font-family contains "Mercury-DisplayItalic"
					
				ShareClassSelectBox-2:
					height 6% of screen/width
					width 66% of screen/width	
					below ShareClassText-2 8px
					css font-size is "34px"
					css font-family contains "BentonSans-Regular"
					
				@for [7,8,9] as index
					InformationBox-${index}:
					
						height 17% of screen/width
						width 19% of screen/width
						below ShareClassSelectBox-2 28px
						
				FilterFundBackground:
						height 37% of screen/width
						width 100% of screen/width
						below HeaderImage 24px
						
				FilterText:
				
						below HeaderImage 55px
						css font-size is "21px"
						css font-family contains "Mercury-DisplayRoman"
						
						
				FilterTextBox:
						height 45px
						width 98% of screen/width
						below FilterFundBackground -221px
						
						
				SearchButton:
						height 47px
						width 32px
						below FilterFundBackground -221px
						left-of FilterTextBox -737px
						
						
				AssetClassTextBox:
						height 43px
						width 29% of screen/width
						below FilterFundBackground -146px
						 
						
						
				TypeTextBox:
						height 43px
						width 29% of screen/width
						below FilterFundBackground -146px
						aligned horizontally top AssetClassTextBox 
						
				DomiciletextBox:
						height 43px
						width 29% of screen/width
						below FilterFundBackground -146px
						aligned horizontally top TypeTextBox 
						
						
						
				TextBoxText-*:
					height 17px
					css font-size is "14px"
					css font-family contains "BentonSans-Bold"
					
					
				ResultText:
					css font-size is "16px"
					css font-family contains "BentonSans-Regular"
					below AssetClassTextBox 153px
					aligned vertically left FilterText  
					
					
				AtGlanceBox-*:
					height 5% of screen/width
					width 13% of screen/width
					css font-size is "11px"
					css font-family contains "BentonSans-Medium"
					below ResultText 21px
			
					
				
						
			
							
							
				
						
							
			
				
					
				
						
					
				
	
					
		
				
					
		
					
			