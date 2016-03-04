# .bashrc

# Source global definitions
if [ -f /etc/bashrc ]; then
	. /etc/bashrc
fi

# User specific aliases and functions
[ -r /home/vagrant/.byobu/prompt ] && . /home/vagrant/.byobu/prompt   #byobu-prompt#
