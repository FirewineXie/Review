CentOS7使用的是firewall防火墙，不再是原来的iptables

1：查看firewall防火墙状态

        firewall-cmd --state
    
        或者
    
        systemctl status firewalld

2：打开防火墙

        systemctl start firewalld

3：关闭防火墙

        systemctl stop firewalld

4：重启防火墙

        firewall-cmd --relaod
    
        或者
    
        systemctl reload firewalld

5：开机自启动防火墙

        systemctl enable firewalld

6：禁止开机启动防火墙

        systemctl disable firewalld

6：查看已打开的端口

        firewall-cmd --list-ports

7：打开端口

        firewall-cmd --permanent --zone=public --add-port=8080/tcp
          firewall-cmd --permanent --zone=public --add-port=16010
    
        其中permanent表示永久生效，public表示作用域，8080/tcp表示端口和类型

8：关闭端口

        firewall-cmd --permanent --zone=public --remove-port=8080/tcp
