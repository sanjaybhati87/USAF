@objects

		HeaderImage						css					.module-bg-header.wpg-js-bg-paralaxy
		HeaderTitleText					css					.wpg-mbhc-top>h1
		HeaderText						css					.wpg-mbhc-top>p
		FilterFundBackground			css					.wl-fundfilter
		FilterText						css					.wl-fundfilter__title
		FilterTextBox					css					#fundfilter-search
		SearchButton					css					.wl-fundfilter__search>button
		DocumentTypeTextBox				css					#select2-search-doctype-container
		LanguageTextBox					css					#select2-search-language-container
		FundTypeTextBox					css					#select2-search-fundtype-container
		FundsTextBox					css					#select2-search-funds-container
		
		AssetClassTextBox				css					#select2-asset-class-container
		TypeTextBox						css					#select2-search-type-container
		DomiciletextBox					css					#select2-search-domicile-container
		TextBoxText-*					css					.select2-selection__placeholder
		ResultText						css					.wl-fundlist__info
		ViewAllFundText					css					.wl-fundlist__viewall
		FundsHeader-*					css					.sorting
		FundNameBox-*					css					.highlighted.odd>td
		EvenFundDetailbox-*				css					.even>td
		ISIN-*							css					.wl-table__title__top
		FundName-*						css					.wl-table__title__bottom
		TickMark-*						css					.zmdi.zmdi-check-circle
		
		
		
		
		
=Header=
	 
		HeaderImage:
			height 365px
			width 1349px
			
		HeaderTitleText:
			height 79px
			inside  HeaderImage 86px top
			css font-size is "50px"
			css font-family contains "Mercury-DisplayRoman"
			
		HeaderText:
			width 800px
			inside  HeaderImage 180px top
			css font-size is "21px"
			css font-family contains "Mercury-DisplayRoman"
			
=Body=

		FilterFundBackground:
				height 354px
				width 1349px
				below HeaderImage 0px
		
		FilterText:
		
				below HeaderImage 31px
				css font-size is "21px"
				css font-family contains "Mercury-DisplayRoman"
				
				
		FilterTextBox:
				height 45px
				width 960px
				below FilterFundBackground -284px
				aligned vertically left FilterText  
		
		SearchButton:
				height 47px
				width 32px
				below FilterFundBackground -284px
				left-of FilterTextBox -938px
				
		DocumentTypeTextBox	:
		
				height 43px
				width 225px
				below FilterFundBackground -209px
				aligned vertically left FilterText 
				
				
		AssetClassTextBox:
				height 43px
				width 225px
				below FilterFundBackground -209px
				aligned horizontally top DocumentTypeTextBox
				
		LanguageTextBox:
				height 43px
				width 225px
				below FilterFundBackground -209px
				aligned horizontally top DocumentTypeTextBox
				
		FundTypeTextBox:
				height 43px
				width 225px
				below FilterFundBackground -209px
				aligned horizontally top DocumentTypeTextBox
				
		FundsTextBox:
				height 43px
				width 225px
				below FilterFundBackground -146px
				aligned vertically left DocumentTypeTextBox
				
				
		
		TextBoxText-*:
			height 17px
			css font-size is "14px"
			css font-family contains "BentonSans-Bold"
			
		ResultText:
			css font-size is "17px"
			css font-family contains "BentonSans-Regular"
			below AssetClassTextBox 246px
			aligned vertically left FilterText 
			
			
		FundsHeader-*	:
			height 94px
			css font-size is "11px"
			css font-family contains "BentonSans-CondensedBlack" 
			
		@forEach [FundsHeader-*] as FundsHeader, prev as previousFundsHeader
			${FundsHeader}:
				aligned horizontally top ${previousFundsHeader}
				
		
			FundNameBox-1:
				height 59px
				width 362px
				css font-size is "12px"
				css font-family contains "BentonSans-Bold"
				
		EvenFundDetailbox-1:
					height 59px
					width 362px
					css font-size is "12px"
					css font-family contains "BentonSans-Bold"
				
			
		@for [2-6] as index
				EvenFundDetailbox-${index}:
					height 59px
					width 119px
					css font-size is "12px"
					css font-family contains "BentonSans-Bold"
					aligned horizontally top EvenFundDetailbox-1
					
					
		TickMark-*:
					height 36px
					width 30px
			
			
			
		
			
			