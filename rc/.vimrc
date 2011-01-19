" Vim 
set nocompatible

"set runtimepath=~/.vim,~/usr/share/vim/vim70,$VIMRUNTIME
 
" Make external commands work through a pipe instead of a pseudo-tty
"set noguipty
 
" set the X11 font to use
" set guifont=-misc-fixed-medium-r-normal--14-130-75-75-c-70-iso8859-1
set encoding=utf-8

set t_Co=256
 
set viminfo='10,\"100,:20,%,n~/.vim/viminfo

au BufReadPost * if line("'\"") > 0|if line("'\"") <= line("$")|exe("norm '\"")|else|exe "norm $"|endif|endif

" Make command line :two lines high
set ch=2
 
set textwidth=78
 
    set tabstop=2
 
"An indentation level every four columns"

    set expandtab
 
"Convert all tabs typed into spaces"

    set shiftwidth=2
 
"Indent/outdent by four columns"

    set shiftround
 
"Always indent/outdent to the nearest tabstop"
 
set paste
set pastetoggle=<f11>
 
set nocindent
set noautoindent
set nobackup
set ruler
 
set ignorecase
 
" Only do this for Vim version 5.0 and later.
"if version >= 500
 
" I like highlighting strings inside C comments
"let c_comment_strings=1
 
" Switch on syntax highlighting.
syntax on
 
" Switch on search pattern highlighting.
set hlsearch
 
" Hide the mouse pointer while typing
set mousehide
 
" Set nice colors
" background for normal text is light grey
" Text below the last line is darker grey
" Cursor is green
" Constants are not underlined but have a slightly lighter background
"highlight Normal   guibg=grey90
"highlight Cursor   guibg=Green guifg=NONE
"highlight NonText  guibg=grey80
"highlight Constant gui=NONE guibg=grey95
"highlight Special  gui=NONE guibg=grey95

" hi Comment         ctermfg=darkgrey
" hi Constant        ctermfg=lightblue
" hi Character       ctermfg=blue
" hi Special         ctermfg=blue
" hi Conditional     ctermfg=blue
" hi Statement       ctermfg=green
" hi Number          ctermfg=darkgreen
" hi String          ctermfg=blue
" hi Identifier      ctermfg=lightblue
" hi Search          ctermbg=LightGreen ctermfg=white
" hi Cursor          ctermbg=green ctermfg=white
" hi Keyword         ctermfg=green
 
"colorscheme brookstream256
"colorscheme dw_green256
colorscheme pyte256

"endif

" Tabs
nnoremap <silent> <C-n><nobr> <wbr></nobr>:tabnext<CR>
nnoremap <silent> <C-p><nobr> <wbr></nobr>:tabprevious<CR>
 
" GenUtils plugin

" Add the following command to your vimrc to turn off diff settings.
    command! DiffOff :call CleanDiffOptions()
    
" Add the following commands to create simple sort commands.
    command! -nargs=0 -range=% SortByLength <line1>,<line2>call QSort(
        \ 'CmpByLineLengthNname', 1)
    command! -nargs=0 -range=% RSortByLength <line1>,<line2>call QSort(
        \ 'CmpByLineLengthNname', -1)
    command! -nargs=0 -range=% SortJavaImports <line1>,<line2>call QSort(
        \ 'CmpJavaImports', 1)
                                                                          
" You might like the following mappings to adjust spacing:
    nnoremap <silent> <C-Space> :call ShiftWordInSpace(1)<CR>
    nnoremap <silent> <C-BS> :call ShiftWordInSpace(-1)<CR>
    nnoremap <silent> \cw :call CenterWordInSpace()<CR>
    nnoremap <silent> \va :call AlignWordWithWordInPreviousLine()<CR>
                                                                          
" The :find command is very useful to search for a file in path, but it
" doesn't support file completion. Add the following command in your vimrc
" to add this functionality:
    command! -nargs=1 -bang -complete=custom,<SID>PathComplete FindInPath
          \ :find<bang> <args>
    function! s:PathComplete(ArgLead, CmdLine, CursorPos)
      return UserFileComplete(a:ArgLead, a:CmdLine, a:CursorPos, 1, &path)
    endfunction
                                                                          
" If you are running commands that generate multiple pages of output, you
" might find it useful to redirect the output to a new buffer. Put the
" following command in your vimrc:
    command! -nargs=* -complete=command Redir
          \ :new | put! =GetVimCmdOutput('<args>') | setl bufhidden=wipe |
          \ setl nomodified 

set wmh=0
set wmw=0                                                                                                                                                                                   
nmap <c-h> <c-w>h<c-w><bar>
nmap <c-l> <c-w>l<c-w><bar>
nmap <F6> <C-W>w
nmap - <C-W>-
nmap + <C-W>+
nmap <C-J> <C-W>j<C-W>_
nmap <C-K> <C-W>k<C-W>_

" Arrow key support
set t_ku =OA
set t_kd =OB
set t_kr =OC
set t_kl =OD
