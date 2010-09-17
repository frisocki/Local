
set background=light

hi clear
if exists("syntax_on")
  syntax reset
endif

let colors_name = "pyte"
"
" Html-Titles
hi Title      ctermfg=234	 cterm=bold
hi Underlined  ctermfg=234	 cterm=underline


hi Cursor    ctermfg=0	   ctermbg=249	
hi lCursor   ctermfg=0	   ctermbg=15	
hi LineNr    ctermfg=15	 ctermbg=152	

hi Normal    ctermfg=234	   ctermbg=253

hi StatusLine ctermfg=15	 ctermbg=103	 cterm=bold,none
hi StatusLineNC ctermfg=59	 ctermbg=145	 cterm=none
hi VertSplit ctermfg=145	 ctermbg=145	 cterm=NONE

hi Folded    ctermfg=66	 ctermbg=152	

hi NonText                 ctermbg=7	
" Kommentare
hi Comment   ctermfg=145	               cterm=none

" Konstanten
hi Constant  ctermfg=131	
hi String    ctermfg=61	 
hi Number    ctermfg=71	
hi Float     ctermfg=71	
"hi Statement ctermfg=26	 cterm=NONE
" Python: def and so on, html: tag-names
hi Statement  ctermfg=22	 cterm=bold


" HTML: arguments
hi Type       ctermfg=178	 cterm=none
" Python: Standard exceptions, True&False
hi Structure  ctermfg=22	 cterm=none
hi Function   ctermfg=18	 cterm=none

hi Identifier ctermfg=240	 cterm=none

hi Repeat      ctermfg=107	 cterm=bold
hi Conditional ctermfg=64	 cterm=bold

" Cheetah: #-Symbol, function-names
hi PreProc    ctermfg=25	 cterm=NONE
" Cheetah: def, for and so on, Python: Decorators
hi Define      ctermfg=25	 cterm=bold

hi Error      ctermfg=15	 ctermbg=9	
hi Todo       ctermfg=145	 ctermbg=0 cterm=none,bold,underline

" Python: %(...)s - constructs, encoding
hi Special    ctermfg=74	 cterm=none

hi Operator   ctermfg=64	

" color of <TAB>s etc...  
hi SpecialKey ctermfg=180	 ctermbg=7	 cterm=none  

